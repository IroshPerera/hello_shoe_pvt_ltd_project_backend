package lk.ijse.gdse.hello_shoe_pvt_ltd.service;


import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.InventoryDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra.InventoryDetailsDTO;


public interface InventoryService extends SuperService<String, InventoryDTO>{
    boolean add(InventoryDetailsDTO inventoryDetailsDTO) ;
}
