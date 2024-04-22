package lk.ijse.gdse.hello_shoe_pvt_ltd.controller;

import java.util.List;

public interface CustomerController<ID,T> extends SuperController{
    public boolean saveCustomer(T customerDTO);
    public boolean updateCustomer(T customerDTO);
    public boolean deleteCustomer(ID customer_code);
    public T searchCustomer(ID customer_code);
    public List<T> getAllCustomers();
}
