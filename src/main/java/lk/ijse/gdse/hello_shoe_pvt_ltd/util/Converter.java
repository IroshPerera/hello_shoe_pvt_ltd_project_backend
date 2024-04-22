package lk.ijse.gdse.hello_shoe_pvt_ltd.util;

import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.CustomerDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.EmployeeDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SupplierDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.CustomerEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.EmployeeEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.SupplierEntity;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    //set customer dtos values to temCustomer entity
    public void convertCustomerEntity(CustomerDTO customerDTO, CustomerEntity tmpCustomerEntity) {
        tmpCustomerEntity.setCustomer_code(customerDTO.getCustomer_code());
        tmpCustomerEntity.setName(customerDTO.getName());
        tmpCustomerEntity.setGender(customerDTO.getGender());
        tmpCustomerEntity.setDate(customerDTO.getDate());
        tmpCustomerEntity.setLevel(customerDTO.getLevel());
        tmpCustomerEntity.setPoint(customerDTO.getPoint());
        tmpCustomerEntity.setDob(customerDTO.getDob());
        tmpCustomerEntity.setBuilding_number(customerDTO.getBuilding_number());
        tmpCustomerEntity.setLane(customerDTO.getLane());
        tmpCustomerEntity.setCity(customerDTO.getCity());
        tmpCustomerEntity.setState(customerDTO.getState());
        tmpCustomerEntity.setPostal_code(customerDTO.getPostal_code());
        tmpCustomerEntity.setContact(customerDTO.getContact());
        tmpCustomerEntity.setEmail(customerDTO.getEmail());
        tmpCustomerEntity.setRecent_purchase(customerDTO.getRecent_purchase());

    }

    //set supplier dtos values to temSupplier entity
    public void convertSupplierEntity(SupplierDTO supplierDTO, SupplierEntity tmpSupplierEntity) {
        tmpSupplierEntity.setSupplier_code(supplierDTO.getSupplier_code());
        tmpSupplierEntity.setName(supplierDTO.getName());
        tmpSupplierEntity.setCategory(supplierDTO.getCategory());
        tmpSupplierEntity.setBuilding_number(supplierDTO.getBuilding_number());
        tmpSupplierEntity.setLane(supplierDTO.getLane());
        tmpSupplierEntity.setCity(supplierDTO.getCity());
        tmpSupplierEntity.setState(supplierDTO.getState());
        tmpSupplierEntity.setPostal_code(supplierDTO.getPostal_code());
        tmpSupplierEntity.setCountry(supplierDTO.getCountry());
        tmpSupplierEntity.setMobile_contact(supplierDTO.getMobile_contact());
        tmpSupplierEntity.setLandline_contact(supplierDTO.getLandline_contact());
        tmpSupplierEntity.setEmail(supplierDTO.getEmail());

    }

    //set employee entity values to temEmployee dto
    public void convertEmployeeEntity(EmployeeDTO employeeDTO, EmployeeEntity tmpEmployeeEntity) {
        tmpEmployeeEntity.setEmployee_code(employeeDTO.getEmployee_code());
        tmpEmployeeEntity.setName(employeeDTO.getName());
        tmpEmployeeEntity.setProfile_pic(employeeDTO.getProfile_pic());
        tmpEmployeeEntity.setGender(employeeDTO.getGender());
        tmpEmployeeEntity.setStatus(employeeDTO.getStatus());
        tmpEmployeeEntity.setDesignation(employeeDTO.getDesignation());
        tmpEmployeeEntity.setRole(employeeDTO.getRole());
        tmpEmployeeEntity.setDob(employeeDTO.getDob());
        tmpEmployeeEntity.setJoined_date(employeeDTO.getJoined_date());
        tmpEmployeeEntity.setBranch(employeeDTO.getBranch());
        tmpEmployeeEntity.setBuilding_number(employeeDTO.getBuilding_number());
        tmpEmployeeEntity.setLane(employeeDTO.getLane());
        tmpEmployeeEntity.setCity(employeeDTO.getCity());
        tmpEmployeeEntity.setState(employeeDTO.getState());
        tmpEmployeeEntity.setPostal_code(employeeDTO.getPostal_code());
        tmpEmployeeEntity.setContact(employeeDTO.getContact());
        tmpEmployeeEntity.setEmail(employeeDTO.getEmail());
        tmpEmployeeEntity.setGuardian_name(employeeDTO.getGuardian_name());
        tmpEmployeeEntity.setGuardian_contact(employeeDTO.getGuardian_contact());

    }
}
