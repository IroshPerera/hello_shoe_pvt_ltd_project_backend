package lk.ijse.gdse.hello_shoe_pvt_ltd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BranchDTO implements SuperDTO{
    private String branch_code;
    private String branch_name;
    private String branch_manager;
    private String address;
    private String contact;
    private Integer no_of_employee;

    private List<EmployeeDTO> employees;
}
