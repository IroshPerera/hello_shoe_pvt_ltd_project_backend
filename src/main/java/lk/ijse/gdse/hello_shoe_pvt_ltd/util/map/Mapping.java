package lk.ijse.gdse.hello_shoe_pvt_ltd.util.map;

import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.*;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra.SaleDetailsDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Mapping {
    private final ModelMapper modelMapper;

    //customer mappings

    public CustomerDTO mapToCustomerDTO(CustomerEntity customerEntity) {
        return modelMapper.map(customerEntity, CustomerDTO.class);

    }

    public CustomerEntity mapToCustomerEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }

    public List<CustomerDTO> mapToCustomerDTOList(List<CustomerEntity> customerEntities) {
        return customerEntities.stream().map(hotel -> modelMapper.map(hotel, CustomerDTO.class)).collect(Collectors.toList());
    }

    //supplier mappings

    public SupplierDTO mapToSupplierDTO(SupplierEntity supplierEntity) {
        return modelMapper.map(supplierEntity, SupplierDTO.class);
    }

    public SupplierEntity mapToSupplierEntity(SupplierDTO supplierDTO) {
        return modelMapper.map(supplierDTO, SupplierEntity.class);
    }

    public List<SupplierDTO> mapToSupplierDTOList(List<SupplierEntity> supplierEntities) {
        return supplierEntities.stream().map(hotel -> modelMapper.map(hotel, SupplierDTO.class)).collect(Collectors.toList());
    }

    //employee mappings

    public EmployeeDTO mapToEmployeeDTO(EmployeeEntity employeeEntity) {
        if (employeeEntity == null) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployee_code(employeeEntity.getEmployee_code());
        employeeDTO.setName(employeeEntity.getName());
        employeeDTO.setProfile_pic(employeeEntity.getProfile_pic());
        employeeDTO.setGender(employeeEntity.getGender());
        employeeDTO.setStatus(employeeEntity.getStatus());
        employeeDTO.setDesignation(employeeEntity.getDesignation());
        employeeDTO.setRole(employeeEntity.getRole());
        employeeDTO.setDob(employeeEntity.getDob());
        employeeDTO.setJoined_date(employeeEntity.getJoined_date());
        employeeDTO.setBuilding_number(employeeEntity.getBuilding_number());
        employeeDTO.setLane(employeeEntity.getLane());
        employeeDTO.setCity(employeeEntity.getCity());
        employeeDTO.setState(employeeEntity.getState());
        employeeDTO.setPostal_code(employeeEntity.getPostal_code());
        employeeDTO.setContact(employeeEntity.getContact());
        employeeDTO.setEmail(employeeEntity.getEmail());
        employeeDTO.setGuardian_name(employeeEntity.getGuardian_name());
        employeeDTO.setGuardian_contact(employeeEntity.getGuardian_contact());

        BranchEntity branchEntity = employeeEntity.getBranch();
        if (branchEntity != null) {
            BranchDTO branchDTO = new BranchDTO();
            branchDTO.setBranch_code(branchEntity.getBranch_code());
            branchDTO.setBranch_name(branchEntity.getBranch_name());
            branchDTO.setBranch_manager(branchEntity.getBranch_manager());
            branchDTO.setAddress(branchEntity.getAddress());
            branchDTO.setContact(branchEntity.getContact());
            branchDTO.setNo_of_employee(branchEntity.getNo_of_employee());
            // Add employees if needed
            employeeDTO.setBranch(branchDTO);
        }

        return employeeDTO;
    }

    public EmployeeEntity mapToEmployeeEntity(EmployeeDTO employeeDTO) {
        return modelMapper.map(employeeDTO, EmployeeEntity.class);
    }

    public List<EmployeeDTO> mapToEmployeeDTOList(List<EmployeeEntity> employeeEntities) {
        return modelMapper.map(employeeEntities, List.class);
    }

    //inventory mappings
    public InventoryDTO mapToInventoryDTO(InventoryEntity inventoryEntity) {
        return modelMapper.map(inventoryEntity, InventoryDTO.class);
    }

    public InventoryEntity mapToInventoryEntity(InventoryDTO inventoryDTO) {
        return modelMapper.map(inventoryDTO, InventoryEntity.class);
    }

    public List<InventoryDTO> mapToInventoryDTOList(List<InventoryEntity> inventoryEntities) {
        return inventoryEntities.stream().map(hotel -> modelMapper.map(hotel, InventoryDTO.class)).collect(Collectors.toList());
    }


    //return mapping
    public ReturnDTO mapToReturnDTO(ReturnEntity returnEntity) {
        return modelMapper.map(returnEntity, ReturnDTO.class);
    }

    public ReturnEntity mapToReturnEntity(ReturnDTO returnDTO) {
        return modelMapper.map(returnDTO, ReturnEntity.class);
    }

    public List<ReturnDTO> mapToReturnDTOList(List<ReturnEntity> returnEntities) {
        return modelMapper.map(returnEntities, List.class);
    }

    //sale mapping
    public SaleDTO mapToSaleDTO(SaleEntity saleEntity) {
        return modelMapper.map(saleEntity, SaleDTO.class);
    }

    public SaleEntity mapToSaleEntity(SaleDTO saleDTO) {
        return modelMapper.map(saleDTO, SaleEntity.class);
    }

    public List<SaleDTO> mapToSaleDTOList(List<SaleEntity> saleEntities) {
        return saleEntities.stream().map(hotel -> modelMapper.map(hotel, SaleDTO.class)).collect(Collectors.toList());
    }

    //size mapping

    public SizeDTO mapToSizeDTO(SizeEntity sizeEntity) {
        return modelMapper.map(sizeEntity, SizeDTO.class);
    }

    public SizeEntity mapToSizeEntity(SizeDTO sizeDTO) {
        return modelMapper.map(sizeDTO, SizeEntity.class);
    }

    public List<SizeDTO> mapToSizeDTOList(List<SizeEntity> sizeEntities) {
        return modelMapper.map(sizeEntities, List.class);
    }

    //sale inventory details mapping

    public SaleInventoryDetailsDTO mapToSaleInventoryDetailsDTO(SaleInventoryDetailsEntity saleInventoryDetailsEntity) {
        return modelMapper.map(saleInventoryDetailsEntity, SaleInventoryDetailsDTO.class);
    }

    public SaleInventoryDetailsEntity mapToSaleInventoryDetailsEntity(SaleInventoryDetailsDTO saleInventoryDetailsDTO) {
        return modelMapper.map(saleInventoryDetailsDTO, SaleInventoryDetailsEntity.class);
    }

    public List<SaleInventoryDetailsDTO> mapToSaleInventoryDetailsDTOList(List<SaleInventoryDetailsEntity> saleInventoryDetailsEntities) {
        return saleInventoryDetailsEntities.stream().map(hotel -> modelMapper.map(hotel, SaleInventoryDetailsDTO.class)).collect(Collectors.toList());
    }

    public List<SaleInventoryDetailsEntity> mapToSaleDetailsDTO(SaleDetailsDTO saleDTO) {


        List<SaleInventoryDetailsEntity> saleInventoryDetailsEntities = new ArrayList<>();


        for (SaleInventoryDetailsDTO saleInventoryDetailsDTO : saleDTO.getSaleInventoryDetailsDTO()) {

            SaleInventoryDetailsEntity saleInventoryDetailsEntity = new SaleInventoryDetailsEntity();

            saleInventoryDetailsEntity.setId(saleInventoryDetailsDTO.getId());
            saleInventoryDetailsEntity.setSale(mapToSaleEntity(saleInventoryDetailsDTO.getSale()));
            saleInventoryDetailsEntity.setInventory(mapToInventoryEntity(saleInventoryDetailsDTO.getInventory()));
            saleInventoryDetailsEntity.setSize(saleInventoryDetailsDTO.getSize());
            saleInventoryDetailsEntity.setSelling_price(saleInventoryDetailsDTO.getSelling_price());
            saleInventoryDetailsEntity.setItem_qty(saleInventoryDetailsDTO.getItem_qty());
            saleInventoryDetailsEntities.add(saleInventoryDetailsEntity);
        }

        return saleInventoryDetailsEntities;


    }

    public List<SizeInventoryDetailsEntity> mapToSizeInventoryDetailsEntity(List<SizeInventoryDetailsDTO> sizeInventoryDetailsDTO) {
        List<SizeInventoryDetailsEntity> sizeInventoryDetailsEntities = new ArrayList<>();
        for (SizeInventoryDetailsDTO sizeInventoryDetailsDTO1 : sizeInventoryDetailsDTO) {
            SizeInventoryDetailsEntity sizeInventoryDetailsEntity = new SizeInventoryDetailsEntity();
            sizeInventoryDetailsEntity.setId(sizeInventoryDetailsDTO1.getId());
            sizeInventoryDetailsEntity.setSize_code(mapToSizeEntity(sizeInventoryDetailsDTO1.getSize()));
            sizeInventoryDetailsEntity.setItem_code(mapToInventoryEntity(sizeInventoryDetailsDTO1.getInventory()));
            sizeInventoryDetailsEntity.setStatus(sizeInventoryDetailsDTO1.getStatus());
            sizeInventoryDetailsEntity.setQty(sizeInventoryDetailsDTO1.getQty());
            sizeInventoryDetailsEntity.setBuying_price(sizeInventoryDetailsDTO1.getBuying_price());
            sizeInventoryDetailsEntity.setSelling_price(sizeInventoryDetailsDTO1.getSelling_price());
            sizeInventoryDetailsEntity.setExpected_profit(sizeInventoryDetailsDTO1.getExpected_profit());
            sizeInventoryDetailsEntity.setProfit_margin(sizeInventoryDetailsDTO1.getProfit_margin());
            sizeInventoryDetailsEntities.add(sizeInventoryDetailsEntity);
        }
        return sizeInventoryDetailsEntities;


    }

    //branch mapping

    public BranchDTO mapToBranchDTO(BranchEntity branchEntity) {
        return modelMapper.map(branchEntity, BranchDTO.class);
    }

    public BranchEntity mapToBranchEntity(BranchDTO branchDTO) {
        return modelMapper.map(branchDTO, BranchEntity.class);
    }

    public List<BranchDTO> mapToBranchDTOList(List<BranchEntity> branchEntities) {
        return branchEntities.stream().map(hotel -> modelMapper.map(hotel, BranchDTO.class)).collect(Collectors.toList());
    }

    public List<EmployeeEntity> mapToEmployeeEntities(List<EmployeeDTO> employees) {
        return employees.stream().map(hotel -> modelMapper.map(hotel, EmployeeEntity.class)).collect(Collectors.toList());
    }

    public UserEntity toUserEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }

    public void toUserDTO(UserEntity save) {

    }


    public SizeInventoryDetailsDTO mapToSizeInventoryDetailsDTO(SizeInventoryDetailsEntity sizeInventoryDetailsEntity) {
        SizeInventoryDetailsDTO sizeDetailsDTO = new SizeInventoryDetailsDTO();

        sizeDetailsDTO.setId(sizeInventoryDetailsEntity.getId());
        sizeDetailsDTO.setSize(mapToSizeDTO(sizeInventoryDetailsEntity.getSize_code()));
//        sizeDetailsDTO.setInventory(mapToInventoryDTO(sizeInventoryDetailsEntity.getItem_code()));
        sizeDetailsDTO.setStatus(sizeInventoryDetailsEntity.getStatus());
        sizeDetailsDTO.setQty(sizeInventoryDetailsEntity.getQty());
        sizeDetailsDTO.setBuying_price(sizeInventoryDetailsEntity.getBuying_price());
        sizeDetailsDTO.setSelling_price(sizeInventoryDetailsEntity.getSelling_price());
        sizeDetailsDTO.setExpected_profit(sizeInventoryDetailsEntity.getExpected_profit());
        sizeDetailsDTO.setProfit_margin(sizeInventoryDetailsEntity.getProfit_margin());

        return sizeDetailsDTO;

    }

    public SizeInventoryDetailsEntity mapToSizeInventoryDetailEntity(SizeInventoryDetailsDTO sizeInventoryDetailsDTO) {
        SizeInventoryDetailsEntity sizeInventoryDetailsEntity = new SizeInventoryDetailsEntity();

        sizeInventoryDetailsEntity.setId(sizeInventoryDetailsDTO.getId());
        sizeInventoryDetailsEntity.setSize_code(mapToSizeEntity(sizeInventoryDetailsDTO.getSize()));
        sizeInventoryDetailsEntity.setItem_code(mapToInventoryEntity(sizeInventoryDetailsDTO.getInventory()));
        sizeInventoryDetailsEntity.setStatus(sizeInventoryDetailsDTO.getStatus());
        sizeInventoryDetailsEntity.setQty(sizeInventoryDetailsDTO.getQty());
        sizeInventoryDetailsEntity.setBuying_price(sizeInventoryDetailsDTO.getBuying_price());
        sizeInventoryDetailsEntity.setSelling_price(sizeInventoryDetailsDTO.getSelling_price());
        sizeInventoryDetailsEntity.setExpected_profit(sizeInventoryDetailsDTO.getExpected_profit());
        sizeInventoryDetailsEntity.setProfit_margin(sizeInventoryDetailsDTO.getProfit_margin());

        return sizeInventoryDetailsEntity;
    }

    public List<ReturnEntity> mapToReturnEntityList(List<ReturnDTO> returnDTO) {
        return returnDTO.stream().map(hotel -> modelMapper.map(hotel, ReturnEntity.class)).collect(Collectors.toList());
    }

    public List<UserDTO> toUserDTOs(List<UserEntity> all) {
        return all.stream().map(hotel -> modelMapper.map(hotel, UserDTO.class)).collect(Collectors.toList());
    }
}
