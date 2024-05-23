package lk.ijse.gdse.hello_shoe_pvt_ltd.service;

import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SaleInventoryDetailsDTO;

import java.util.List;

public interface SaleInventoryDetailsService{
    public boolean
    add(List<SaleInventoryDetailsDTO> saleInventoryDetailsDTO);

    public boolean delete(String s) ;

    public boolean update(SaleInventoryDetailsDTO saleInventoryDetailsDTO) ;

    public SaleInventoryDetailsDTO search(String s) ;

    public List<SaleInventoryDetailsDTO> getAll() ;

    void updateStatus(String orderId, String itemCode, String sizeCode, String returned);
}
