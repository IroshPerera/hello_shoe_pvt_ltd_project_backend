package lk.ijse.gdse.hello_shoe_pvt_ltd.service;

import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.BranchDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.EmployeeDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra.EmployeeCountDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra.EmployeeDesigCountsDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.enums.Designation;

import java.util.List;

public interface EmployeeService extends SuperService<String, EmployeeDTO> {
    BranchDTO getBranch(String employeeCode);

    String getEmployeeCode();

    List<Designation> getDesignations();

    EmployeeCountDTO getEmployeeCount();

    EmployeeDesigCountsDTO getEmployeeCountByDesignation();

    String getBranchCodeByEmployeeCode(String cashierName);

    List<String> getEmployeeCountByBranch();
}
