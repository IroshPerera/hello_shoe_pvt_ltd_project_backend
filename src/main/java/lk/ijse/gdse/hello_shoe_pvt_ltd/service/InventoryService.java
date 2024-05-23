package lk.ijse.gdse.hello_shoe_pvt_ltd.service;


import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.InventoryDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SizeInventoryDetailsDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra.InventoryDetailsDTO;

import java.util.List;


public interface InventoryService extends SuperService<String, InventoryDTO>{
    boolean add(InventoryDetailsDTO inventoryDetailsDTO) ;
    boolean update(List<SizeInventoryDetailsDTO> inventoryDetailsDTO) ;

    List<SizeInventoryDetailsDTO> getSizeDetails(String itemCode);

    String getInventoryCount();
}
