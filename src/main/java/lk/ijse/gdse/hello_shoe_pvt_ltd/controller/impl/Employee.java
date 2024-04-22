package lk.ijse.gdse.hello_shoe_pvt_ltd.controller.impl;

import lk.ijse.gdse.hello_shoe_pvt_ltd.controller.EmployeeController;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.EmployeeDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class Employee implements EmployeeController<String, EmployeeDTO>{

    private final EmployeeService employeeService;

    @GetMapping("/health")
    public String healthCheck() {
        return "Hello I'm Employee Controller. I'm OK! Have a nice day!";
    }

    @PostMapping
    public boolean saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.add(employeeDTO);
    }

    @PutMapping
    public boolean updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.update(employeeDTO);
    }

    @DeleteMapping
    public boolean deleteEmployee(@RequestParam String employee_code) {
        return employeeService.delete(employee_code);
    }

    @GetMapping
    public EmployeeDTO searchEmployee(@RequestParam String employee_code) {
        return employeeService.search(employee_code);
    }

    @GetMapping("/all")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAll();
    }
}
