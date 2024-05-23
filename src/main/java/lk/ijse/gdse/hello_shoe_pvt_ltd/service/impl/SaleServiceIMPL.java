package lk.ijse.gdse.hello_shoe_pvt_ltd.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.BranchDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.InventoryDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SaleDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SaleInventoryDetailsDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra.SaleDetailsDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra.SaleInventoryDetailsTopDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.SaleEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.SaleInventoryDetailsEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.repository.SaleInventoryDetailsRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.repository.SaleRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.repository.SizeInventoryDetailsRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.*;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.convert.Converter;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.map.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SaleServiceIMPL implements SaleService {
    private final SaleRepo saleRepo;
    private final SaleInventoryDetailsRepo saleInventoryDetailsRepo;
    private final SizeInventoryDetailsRepo sizeInventoryDetailsRepo;
    private final BranchService branchService;
    private final InventoryService inventoryService;
    private final EmployeeService employeeService;
    private final UserService userService;
    private final Mapping mapping;
    private final Converter converter;


    @Override
    public boolean add(SaleDetailsDTO saleDTO) {

        String employee_code = userService.getEmployeeCode(saleDTO.getSaleDTO().getCashier_name());
        saleDTO.getSaleDTO().setCashier_name(employee_code);

        SaleEntity saleEntity = mapping.mapToSaleEntity(saleDTO.getSaleDTO());
        List<SaleInventoryDetailsEntity> saleInventoryDetailsEntities = mapping.mapToSaleDetailsDTO(saleDTO);

        String employeeID = saleDTO.getSaleDTO().getCashier_name();

        String branchCodeByEmployeeCode = employeeService.getBranchCodeByEmployeeCode(employeeID);

        for (SaleInventoryDetailsEntity saleInventoryDetailsEntity : saleInventoryDetailsEntities) {
            saleInventoryDetailsEntity.setBranch_code(branchCodeByEmployeeCode);
        }


        saleRepo.save(saleEntity);
        for (SaleInventoryDetailsEntity saleInventoryDetailsEntity : saleInventoryDetailsEntities) {
            saleInventoryDetailsEntity.setStatus("Success");
            int size = saleInventoryDetailsEntity.getSize();
            String size_code = "SIZE" + size;
            int currentQty = sizeInventoryDetailsRepo.findQtyByItemCodeAndSize(saleInventoryDetailsEntity.getInventory().getItem_code(), size_code);
            int newQty = currentQty - saleInventoryDetailsEntity.getItem_qty();
            sizeInventoryDetailsRepo.decreaseQty(saleInventoryDetailsEntity.getInventory().getItem_code(), size_code, newQty);
            saleInventoryDetailsEntity.setDate(new Date());
        }
        saleInventoryDetailsRepo.saveAll(saleInventoryDetailsEntities);
        if (saleRepo.existsById(saleEntity.getOrder_id())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String generateSaleID() {
        String current_id = saleRepo.getLastSaleID();
        if (current_id == null) {
            return "O001";
        } else {
            int currentId = Integer.parseInt(current_id.replace("O", ""));
            currentId = currentId + 1;
            String id = "";
            if (currentId < 10) {
                id = "O00" + currentId;
            } else if (currentId < 100) {
                id = "O0" + currentId;
            } else {
                id = "O" + currentId;
            }
            return id;
        }
    }

    @Override
    public List<SaleInventoryDetailsDTO> searchSaleInventory(String orderId) {
        List<SaleInventoryDetailsEntity> saleInventoryDetailsEntityList = saleInventoryDetailsRepo.findAll();
        List<SaleInventoryDetailsDTO> saleInventoryDetailsDTOList = new ArrayList<>();

        /*check first order id has this list*/
        boolean isAvailable = false;
        if (saleInventoryDetailsEntityList.isEmpty() || saleInventoryDetailsEntityList == null) {
            return null;
        }

        for (SaleInventoryDetailsEntity saleInventoryDetailsEntity : saleInventoryDetailsEntityList) {
            if (saleInventoryDetailsEntity.getSale().getOrder_id().equals(orderId)) {
                isAvailable = true;
                break;
            }
        }

        if (!isAvailable) {
            return null;
        }


        for (SaleInventoryDetailsEntity saleInventoryDetailsEntity : saleInventoryDetailsEntityList) {
            if (saleInventoryDetailsEntity.getSale().getOrder_id().equals(orderId) && saleInventoryDetailsEntity.getStatus().equals("Success")) {
                SaleInventoryDetailsDTO saleInventoryDetailsDTO = mapping.mapToSaleInventoryDetailsDTO(saleInventoryDetailsEntity);
                saleInventoryDetailsDTOList.add(saleInventoryDetailsDTO);
            }
        }

        return saleInventoryDetailsDTOList;

    }

    @Override
    public boolean add(SaleDTO saleDTO) {
        return false;
    }

    @Override
    public boolean delete(String order_id) {
        if (saleRepo.existsById(order_id)) {
            saleRepo.deleteById(order_id);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean update(SaleDTO saleDTO) {
        if (saleRepo.existsById(saleDTO.getOrder_id())) {
            SaleEntity saleEntity = saleRepo.getReferenceById(saleDTO.getOrder_id());
            converter.convertSaleEntity(saleDTO, saleEntity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public SaleDTO search(String order_id) {
        if (!saleRepo.existsById(order_id)) {
            return null;
        }
        SaleEntity saleEntity = saleRepo.getReferenceById(order_id);
        return mapping.mapToSaleDTO(saleEntity);

    }

    @Override
    public List<SaleDTO> getAll() {
        return null;

    }

    @Override
    public List<String> getTotalSalesBranches() {

        List<BranchDTO> branches = new ArrayList<>();

        branchService.getAll().forEach(branches::add);

        List<String> branchSales = new ArrayList<>();

        for (BranchDTO branch : branches) {
            branchSales.add(branch.getBranch_name());
            String total = saleInventoryDetailsRepo.getTotalSalesBranch(branch.getBranch_code());
            branchSales.add(total);
        }

        return branchSales;
    }

    @Override
    public List<String> getTotalSalesBranchesThisMonth() {
        List<BranchDTO> branches = new ArrayList<>();


        branchService.getAll().forEach(branches::add);

        List<String> branchSales = new ArrayList<>();

        for (BranchDTO branch : branches) {
            branchSales.add(branch.getBranch_name());
            String total = saleInventoryDetailsRepo.getTotalSalesBranchThisMonth(branch.getBranch_code());
            branchSales.add(total);
        }

        return branchSales;
    }

    @Override
    public SaleInventoryDetailsTopDTO getTotalSalesInventoryThisMonth() {
           String item_code =  saleInventoryDetailsRepo.findMostSoldItemThisMonth();
           String totalSale = saleInventoryDetailsRepo.getTotalSalesItemThisMonth(item_code);
        InventoryDTO inventoryDTO = inventoryService.search(item_code);
        String branch_code = saleInventoryDetailsRepo.findMostSaleBranch(item_code);

        String branchName = branchService.getBranchName(branch_code);

        return new SaleInventoryDetailsTopDTO(inventoryDTO.getItem_pic(),inventoryDTO.getItem_desc(),branchName,totalSale);
    }

    @Override
    public SaleInventoryDetailsTopDTO getTotalSalesInventoryThisYear() {

        String item_code =  saleInventoryDetailsRepo.findMostSoldItemThisYear();
        String totalSale = saleInventoryDetailsRepo.getTotalSalesItemThisYear(item_code);
        InventoryDTO inventoryDTO = inventoryService.search(item_code);
        String branch_code = saleInventoryDetailsRepo.findMostSaleBranchThisYear(item_code);

        String branchName = branchService.getBranchName(branch_code);

        return new SaleInventoryDetailsTopDTO(inventoryDTO.getItem_pic(),inventoryDTO.getItem_desc(),branchName,totalSale);

    }
}
