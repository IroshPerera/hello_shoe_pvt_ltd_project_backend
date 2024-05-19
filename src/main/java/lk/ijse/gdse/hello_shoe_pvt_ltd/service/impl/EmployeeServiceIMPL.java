package lk.ijse.gdse.hello_shoe_pvt_ltd.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.BranchDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra.EmployeeCountDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.repository.EmployeeRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.EmployeeDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.EmployeeEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.EmployeeService;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.convert.Converter;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.enums.Designation;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.enums.Role;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.map.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceIMPL implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final Mapping mapping;
    private final Converter converter;

    @Override
    public boolean add(EmployeeDTO employeeDTO) {

        EmployeeEntity employeeEntity = mapping.mapToEmployeeEntity(employeeDTO);
        employeeDTO.setActive_state("ACTIVE");
        employeeRepo.save(employeeEntity);
        return employeeRepo.existsById(employeeEntity.getEmployee_code());
    }

    @Override
    public boolean delete(String employee_code) {
        if (employeeRepo.existsById(employee_code)) {
            employeeRepo.changeActiveState("DEACTIVATE", employee_code);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(EmployeeDTO employeeDTO) {

        employeeDTO.setActive_state("ACTIVE");
        return add(employeeDTO);

/*        Optional<EmployeeEntity> tmpEmployee = employeeRepo.findById(employeeDTO.getEmployee_code());
        System.out.println(tmpEmployee);

        if (tmpEmployee.isPresent()) {
           // converter.convertEmployeeEntity(employeeDTO, tmpEmployee.get());
            return true;
        }
        return false;*/
    }

    @Override
    public EmployeeDTO search(String employee_code) {
        EmployeeEntity employeeEntity = employeeRepo.getReferenceById(employee_code);
        System.out.println(employeeEntity.getBranch().getBranch_code());
        EmployeeDTO employeeDTO = mapping.mapToEmployeeDTO(employeeEntity);
        System.out.println(employeeDTO.getBranch().getBranch_code());
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> getAll() {
        List<EmployeeEntity> employeeEntities = employeeRepo.findAll();
        return mapping.mapToEmployeeDTOList(employeeEntities);

    }

    @Override
    public BranchDTO getBranch(String employeeCode) {
        EmployeeEntity employeeEntity = employeeRepo.getReferenceById(employeeCode);
        employeeEntity.getBranch().setEmployees(null);
        return mapping.mapToBranchDTO(employeeEntity.getBranch());
    }

    @Override
    public String getEmployeeCode() {
        String currentEmpCode = employeeRepo.getEmployeeCode();
        if (currentEmpCode == null) {
            return "E001";
        } else {
            int empCode = Integer.parseInt(currentEmpCode.substring(1)) + 1;
            if (empCode < 10) {
                return "E00" + empCode;
            } else if (empCode < 100) {
                return "E0" + empCode;
            } else {
                return "E" + empCode;
            }
        }
    }

    @Override
    public List<Designation> getDesignations() {
        List<Designation> designations = List.of(Designation.values());
        return designations;

    }

    @Override
    public EmployeeCountDTO getEmployeeCount() {
        List<EmployeeEntity> employeeEntities = employeeRepo.findAll();

        int admin_employee_count = 0;
        int user_employee_count = 0;

        for (EmployeeEntity employeeEntity : employeeEntities) {
            if (employeeEntity.getRole().equals(Role.ADMIN)) {
                admin_employee_count++;
            } else {
                user_employee_count++;
            }
        }


        return new EmployeeCountDTO(employeeEntities.size(), admin_employee_count, user_employee_count);

    }


}
