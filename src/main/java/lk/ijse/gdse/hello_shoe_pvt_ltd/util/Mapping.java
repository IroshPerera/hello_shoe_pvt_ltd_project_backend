package lk.ijse.gdse.hello_shoe_pvt_ltd.util;

import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.CustomerDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.EmployeeDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SupplierDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.CustomerEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.EmployeeEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.SupplierEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Mapping {
    private final ModelMapper modelMapper;

    //customer mappings

    public CustomerDTO mapToCustomerDTO(CustomerEntity customerEntity){
        return modelMapper.map(customerEntity, CustomerDTO.class);

    }

    public CustomerEntity mapToCustomerEntity(CustomerDTO customerDTO){
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }

    public List<CustomerDTO> mapToCustomerDTOList(List<CustomerEntity> customerEntities){
       return modelMapper.map(customerEntities, List.class);
    }

    //supplier mappings

    public SupplierDTO mapToSupplierDTO(SupplierEntity supplierEntity){
        return modelMapper.map(supplierEntity, SupplierDTO.class);
    }

    public SupplierEntity mapToSupplierEntity(SupplierDTO supplierDTO){
        return modelMapper.map(supplierDTO, SupplierEntity.class);
    }

    public List<SupplierDTO> mapToSupplierDTOList(List<SupplierEntity> supplierEntities){
        return modelMapper.map(supplierEntities, List.class);
    }

    //employee mappings

    public EmployeeDTO mapToEmployeeDTO(EmployeeEntity employeeEntity){
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeEntity mapToEmployeeEntity(EmployeeDTO employeeDTO){
        return modelMapper.map(employeeDTO, EmployeeEntity.class);
    }

    public List<EmployeeDTO> mapToEmployeeDTOList(List<EmployeeEntity> employeeEntities){
        return modelMapper.map(employeeEntities, List.class);
    }

}
