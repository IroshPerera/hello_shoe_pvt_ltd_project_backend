package lk.ijse.gdse.hello_shoe_pvt_ltd.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dao.CustomerRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.CustomerDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.CustomerEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.CustomerService;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.Converter;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.Mapping;
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
        customerRepo.save(customerEntity);
        return customerRepo.existsById(customerEntity.getCustomer_code());
    }

    @Override
    public boolean delete(String customer_code) {
        if (customerRepo.existsById(customer_code)) {
            customerRepo.deleteById(customer_code);
            return true;
        } else {
            return false;
        }


    }

    @Override
    public boolean update(CustomerDTO customerDTO) {
        Optional<CustomerEntity> tmpCustomer = customerRepo.findById(customerDTO.getCustomer_code());
        if (tmpCustomer.isPresent()) {
            converter.convertCustomerEntity(customerDTO, tmpCustomer.get());
            return true;
        }
        return false;
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
}
