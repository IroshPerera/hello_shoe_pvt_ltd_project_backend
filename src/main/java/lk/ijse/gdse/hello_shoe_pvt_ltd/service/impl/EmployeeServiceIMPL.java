package lk.ijse.gdse.hello_shoe_pvt_ltd.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.hello_shoe_pvt_ltd.repository.EmployeeRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.EmployeeDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.EmployeeEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.EmployeeService;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.convert.Converter;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.map.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        employeeRepo.save(employeeEntity);
        return employeeRepo.existsById(employeeEntity.getEmployee_code());
    }

    @Override
    public boolean delete(String employee_code) {
        if (employeeRepo.existsById(employee_code)) {
            employeeRepo.deleteById(employee_code);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(EmployeeDTO employeeDTO) {
        Optional<EmployeeEntity> tmpEmployee = employeeRepo.findById(employeeDTO.getEmployee_code());
        if (tmpEmployee.isPresent()) {
            converter.convertEmployeeEntity(employeeDTO, tmpEmployee.get());
            return true;
        }
        return false;
    }

    @Override
    public EmployeeDTO search(String employee_code) {
        EmployeeEntity employeeEntity = employeeRepo.getReferenceById(employee_code);
        return mapping.mapToEmployeeDTO(employeeEntity);
    }

    @Override
    public List<EmployeeDTO> getAll() {
        List<EmployeeEntity> employeeEntities = employeeRepo.findAll();
        return mapping.mapToEmployeeDTOList(employeeEntities);
    }
}
