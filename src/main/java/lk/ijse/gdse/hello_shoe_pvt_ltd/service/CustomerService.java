package lk.ijse.gdse.hello_shoe_pvt_ltd.service;

import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.CustomerDTO;

import java.sql.Timestamp;

public interface CustomerService extends SuperService<String, CustomerDTO>{
    String generateCustomerID();

    CustomerDTO searchContact(String customerContact);

    void updatePoints(String customerCode, double addedPoints);

    String getCustomerCount();

}
