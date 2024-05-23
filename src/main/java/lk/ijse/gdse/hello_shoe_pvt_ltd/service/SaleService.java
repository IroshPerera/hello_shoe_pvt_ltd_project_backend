package lk.ijse.gdse.hello_shoe_pvt_ltd.service;

import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SaleDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SaleInventoryDetailsDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra.SaleDetailsDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra.SaleInventoryDetailsTopDTO;

import java.util.List;

public interface SaleService extends SuperService<String, SaleDTO>{
    public boolean add(SaleDetailsDTO saleDetailsDTO);

    String generateSaleID();

    List<SaleInventoryDetailsDTO> searchSaleInventory(String orderId);

    List<String> getTotalSalesBranches();

    List<String> getTotalSalesBranchesThisMonth();

    SaleInventoryDetailsTopDTO getTotalSalesInventoryThisMonth();

    SaleInventoryDetailsTopDTO getTotalSalesInventoryThisYear();
}
