package lk.ijse.gdse.hello_shoe_pvt_ltd.util.convert;

import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.*;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.*;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.map.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Converter {

    private Mapping mapping;

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
        tmpEmployeeEntity.setBuilding_number(employeeDTO.getBuilding_number());
        tmpEmployeeEntity.setLane(employeeDTO.getLane());
        tmpEmployeeEntity.setCity(employeeDTO.getCity());
        tmpEmployeeEntity.setState(employeeDTO.getState());
        tmpEmployeeEntity.setPostal_code(employeeDTO.getPostal_code());
        tmpEmployeeEntity.setContact(employeeDTO.getContact());
        tmpEmployeeEntity.setEmail(employeeDTO.getEmail());
        tmpEmployeeEntity.setGuardian_name(employeeDTO.getGuardian_name());
        tmpEmployeeEntity.setGuardian_contact(employeeDTO.getGuardian_contact());
        tmpEmployeeEntity.setBranch(mapping.mapToBranchEntity(employeeDTO.getBranch()));

    }

    //set inventory entity values to temInventory dto
    public void convertInventoryEntity(InventoryDTO inventoryDTO, InventoryEntity tmpInventoryEntity) {
        tmpInventoryEntity.setItem_code(inventoryDTO.getItem_code());
        tmpInventoryEntity.setItem_desc(inventoryDTO.getItem_desc());
        tmpInventoryEntity.setItem_pic(inventoryDTO.getItem_pic());
        tmpInventoryEntity.setOccasion(inventoryDTO.getOccasion());
        tmpInventoryEntity.setGender(inventoryDTO.getGender());
        tmpInventoryEntity.setVerities(inventoryDTO.getVerities());
        tmpInventoryEntity.setSupplier(mapping.mapToSupplierEntity(inventoryDTO.getSupplier()));
       /* tmpInventoryEntity.setCategory(inventoryDTO.getCategory());
        tmpInventoryEntity.setSize(inventoryDTO.getSize());
        tmpInventoryEntity.setSupplier_code(inventoryDTO.getSupplier_code());
        tmpInventoryEntity.setSupplier_name(inventoryDTO.getSupplier_name());
        tmpInventoryEntity.setBuying_price(inventoryDTO.getBuying_price());
        tmpInventoryEntity.setSelling_price(inventoryDTO.getSelling_price());
        tmpInventoryEntity.setExpected_profit(inventoryDTO.getExpected_profit());
        tmpInventoryEntity.setProfit_margin(inventoryDTO.getProfit_margin());
        tmpInventoryEntity.setStatus(inventoryDTO.getStatus());
        tmpInventoryEntity.setQty_on_hand(inventoryDTO.getQty_on_hand());*/
    }

    //set return entity values to temReturn dto
    public void convertReturnEntity(ReturnDTO returnDTO, ReturnEntity tmpReturnEntity) {
        tmpReturnEntity.setReturn_id(returnDTO.getReturn_id());
        tmpReturnEntity.setReturn_date(returnDTO.getReturn_date());
        tmpReturnEntity.setReason(returnDTO.getReason());

    }

    //set sale entity values to temSale dto
    public void convertSaleEntity(SaleDTO saleDTO, SaleEntity tmpSaleEntity) {
        tmpSaleEntity.setOrder_id(saleDTO.getOrder_id());
        // tmpSaleEntity.setItem_code(saleDTO.getItem_code());
        tmpSaleEntity.setCustomer(mapping.mapToCustomerEntity(saleDTO.getCustomer()));
        // tmpSaleEntity.setItem_desc(saleDTO.getItem_desc());
        // tmpSaleEntity.setSize(saleDTO.getSize());
        // tmpSaleEntity.setUnit_price(saleDTO.getUnit_price());
        // tmpSaleEntity.setItem_qty(saleDTO.getItem_qty());
        tmpSaleEntity.setTotal_price(saleDTO.getTotal_price());
        tmpSaleEntity.setPurchase_date(saleDTO.getPurchase_date());
        tmpSaleEntity.setPayment_method(saleDTO.getPayment_method());
        tmpSaleEntity.setAdded_points(saleDTO.getAdded_points());
        tmpSaleEntity.setCashier_name(saleDTO.getCashier_name());
    }

    //set size entity values to temSize dto
    public void convertSizeEntity(SizeDTO sizeDTO, SizeEntity tmpSizeEntity) {
        tmpSizeEntity.setSize_code(sizeDTO.getSize_code());
        tmpSizeEntity.setSize(sizeDTO.getSize());
    }

    //set size inventory details entity values to temSizeInventoryDetails dto
    public void convertBranchEntity(BranchDTO branchDTO, BranchEntity branchEntity) {
        branchEntity.setBranch_code(branchDTO.getBranch_code());
        branchEntity.setBranch_name(branchDTO.getBranch_name());
        branchEntity.setAddress(branchDTO.getAddress());
        branchEntity.setContact(branchDTO.getContact());
        branchEntity.setNo_of_employee(branchDTO.getNo_of_employee());
        branchEntity.setBranch_manager(branchDTO.getBranch_manager());
    }
}
