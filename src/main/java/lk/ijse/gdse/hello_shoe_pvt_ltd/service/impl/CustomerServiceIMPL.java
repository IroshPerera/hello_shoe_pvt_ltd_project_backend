package lk.ijse.gdse.hello_shoe_pvt_ltd.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.hello_shoe_pvt_ltd.repository.CustomerRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.CustomerDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.CustomerEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.CustomerService;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.convert.Converter;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.map.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

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
}
