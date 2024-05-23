package lk.ijse.gdse.hello_shoe_pvt_ltd.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.hello_shoe_pvt_ltd.repository.CustomerRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.CustomerDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.CustomerEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.CustomerService;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.convert.Converter;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.map.Mapping;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.smtp.Mail;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceIMPL implements CustomerService {

    private final CustomerRepo customerRepo;
    private final Mapping mapping;
    private final Converter converter;


    @Override
    public boolean add(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = mapping.mapToCustomerEntity(customerDTO);
        customerEntity.setActive_state("ACTIVE");
        customerRepo.save(customerEntity);
        return customerRepo.existsById(customerEntity.getCustomer_code());
    }

    @Override
    public boolean delete(String customer_code) {
        if (customerRepo.existsById(customer_code)) {

            customerRepo.changeActiveState("DEACTIVATE", customer_code);

            return true;
        } else {
            return false;
        }


    }

    @Override
    public boolean update(CustomerDTO customerDTO) {
       /* Optional<CustomerEntity> tmpCustomer = customerRepo.findById(customerDTO.getCustomer_code());
        if (tmpCustomer.isPresent()) {
            converter.convertCustomerEntity(customerDTO, tmpCustomer.get());
            return true;
        }
        return false;*/
        customerDTO.setActive_state("ACTIVE");
        return add(customerDTO);
    }

    @Override
    public CustomerDTO search(String customer_code) {
        CustomerEntity referenceCustomerEntity = customerRepo.getReferenceById(customer_code);
        return mapping.mapToCustomerDTO(referenceCustomerEntity);
    }

    @Override
    public List<CustomerDTO> getAll() {
        return mapping.mapToCustomerDTOList(customerRepo.findAll());
    }

    @Override
    public String generateCustomerID() {
        String customer_code = customerRepo.generateCustomerID();
        if (customer_code == null) {
            return "C001";
        } else {
            int customerID = Integer.parseInt(customer_code.replace("C", ""));
            customerID++;
            if (customerID < 10) {
                return "C00" + customerID;
            } else if (customerID < 100) {
                return "C0" + customerID;
            } else {
                return "C" + customerID;
            }
        }
    }

    @Override
    public CustomerDTO searchContact(String customerContact) {

        CustomerEntity customerEntity = customerRepo.searchContact(customerContact);
        if (customerEntity != null) {
            return mapping.mapToCustomerDTO(customerEntity);
        } else {
            return null;
        }
    }

    @Override
    public void updatePoints(String customerCode, double addedPoints) {
        CustomerEntity customerEntity = customerRepo.getReferenceById(customerCode);
        Integer currentPoints = customerEntity.getPoint();
        if (currentPoints == 0 ) {
            currentPoints = 0;
        }
        double newPoints = currentPoints + addedPoints;
        customerRepo.updatePoints(customerCode, newPoints);
        customerRepo.updateLastPurchaseDate(customerCode,   new Timestamp(new Date().getTime()));

    }

    @Scheduled(cron = "0 0 8 * * ?")
    @Override
    public String getCustomerCount() {
        return customerRepo.getCustomerCount();
    }

    public void sendMail() {

        /*Get customer birthday*/

       int count = customerRepo.findTodayBirthDayCustomerCount();

       if (count == 0) {
           return;
         }else {
           List<CustomerEntity> customerEntityList = customerRepo.findTodayBirthDayCustomer();
           for (CustomerEntity customerEntity : customerEntityList) {
               sendBirthdayWish(customerEntity);
           }
       }


    }

       public void sendBirthdayWish(CustomerEntity customerEntity) {
           Date date = new Date();
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd");

           /*Send customer birthday wish*/
           // Construct the email message

           String email = "irosh@gmail.com";
           String message = "Dear " + "Irosh" + ",\n\n" +
                   "We wish you a very Happy Birthday on " + date + "!\n" +
                   "May your day be filled with joy, happiness, and lots of memorable moments.\n\n" +
                   "Best regards,\n" +
                   "Hello Shoe (PVT) LTD\n";


           Mail mail = new Mail();
           mail.setMsg(message);//email message
           mail.setTo(email); //receiver's mail
           mail.setSubject("Happy Birthday!"); //email subject

           Thread thread = new Thread(mail);
           thread.start();
       }
}
