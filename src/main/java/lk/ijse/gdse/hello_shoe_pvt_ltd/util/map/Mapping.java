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

    public CustomerDTO mapToCustomerDTO(CustomerEntity customerEntity){
        return modelMapper.map(customerEntity, CustomerDTO.class);

    }

    public CustomerEntity mapToCustomerEntity(CustomerDTO customerDTO){
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }

    public List<CustomerDTO> mapToCustomerDTOList(List<CustomerEntity> customerEntities){
       return customerEntities.stream().map(hotel -> modelMapper.map(hotel, CustomerDTO.class)).collect(Collectors.toList());
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

    //inventory mappings
    public InventoryDTO mapToInventoryDTO(InventoryEntity inventoryEntity){
        return modelMapper.map(inventoryEntity, InventoryDTO.class);
    }

    public InventoryEntity mapToInventoryEntity(InventoryDTO inventoryDTO){
        return modelMapper.map(inventoryDTO, InventoryEntity.class);
    }

    public List<InventoryDTO> mapToInventoryDTOList(List<InventoryEntity> inventoryEntities){
        return inventoryEntities.stream().map(hotel -> modelMapper.map(hotel, InventoryDTO.class)).collect(Collectors.toList());
    }



    //return mapping
    public ReturnDTO mapToReturnDTO(ReturnEntity returnEntity){
        return modelMapper.map(returnEntity, ReturnDTO.class);
    }

    public ReturnEntity mapToReturnEntity(ReturnDTO returnDTO){
       return modelMapper.map(returnDTO, ReturnEntity.class);
    }

    public List<ReturnDTO> mapToReturnDTOList(List<ReturnEntity> returnEntities){
        return modelMapper.map(returnEntities, List.class);
    }

    //sale mapping
    public SaleDTO mapToSaleDTO(SaleEntity saleEntity){
        return modelMapper.map(saleEntity, SaleDTO.class);
    }

    public SaleEntity mapToSaleEntity(SaleDTO saleDTO){
        return modelMapper.map(saleDTO, SaleEntity.class);
    }

    public List<SaleDTO> mapToSaleDTOList(List<SaleEntity> saleEntities){
        return saleEntities.stream().map(hotel -> modelMapper.map(hotel, SaleDTO.class)).collect(Collectors.toList());
    }

    //size mapping

    public SizeDTO mapToSizeDTO(SizeEntity sizeEntity){
        return modelMapper.map(sizeEntity, SizeDTO.class);
    }

    public SizeEntity mapToSizeEntity(SizeDTO sizeDTO){
        return modelMapper.map(sizeDTO, SizeEntity.class);
    }

    public List<SizeDTO> mapToSizeDTOList(List<SizeEntity> sizeEntities){
        return modelMapper.map(sizeEntities, List.class);
    }

    //sale inventory details mapping

    public SaleInventoryDetailsDTO mapToSaleInventoryDetailsDTO(SaleInventoryDetailsEntity saleInventoryDetailsEntity){
        return modelMapper.map(saleInventoryDetailsEntity, SaleInventoryDetailsDTO.class);
    }

    public SaleInventoryDetailsEntity mapToSaleInventoryDetailsEntity(SaleInventoryDetailsDTO saleInventoryDetailsDTO){
        return modelMapper.map(saleInventoryDetailsDTO, SaleInventoryDetailsEntity.class);
    }

    public List<SaleInventoryDetailsDTO> mapToSaleInventoryDetailsDTOList(List<SaleInventoryDetailsEntity> saleInventoryDetailsEntities){
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

    public BranchDTO mapToBranchDTO(BranchEntity branchEntity){
        return modelMapper.map(branchEntity, BranchDTO.class);
    }

    public BranchEntity mapToBranchEntity(BranchDTO branchDTO){
        return modelMapper.map(branchDTO, BranchEntity.class);
    }

    public List<BranchDTO> mapToBranchDTOList(List<BranchEntity> branchEntities){
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
}
