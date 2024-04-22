package lk.ijse.gdse.hello_shoe_pvt_ltd.controller.impl;

import lk.ijse.gdse.hello_shoe_pvt_ltd.controller.CustomerController;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.CustomerDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class Customer implements CustomerController<String, CustomerDTO>{

    private final CustomerService customerService;

    @GetMapping("/health")
    public String healthCheck() {
        return "Hello I'm Customer Controller. I'm OK! Have a nice day!";
    }

    @PostMapping
    public boolean saveCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.add(customerDTO);
    }

    @PutMapping
    public boolean updateCustomer(@RequestBody CustomerDTO customerDTO) {
       return customerService.update(customerDTO);
    }

    @DeleteMapping
    public boolean deleteCustomer(@RequestParam String customer_code) {
        return customerService.delete(customer_code);
    }

    @GetMapping
    public CustomerDTO searchCustomer(@RequestParam String customer_code) {
        return customerService.search(customer_code);
    }

    @GetMapping("/all")
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAll();
    }

}
