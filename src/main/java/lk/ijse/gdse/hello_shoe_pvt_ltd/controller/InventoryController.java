package lk.ijse.gdse.hello_shoe_pvt_ltd.controller;


import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra.InventoryDetailsDTO;

import java.util.List;

public interface InventoryController<ID,T> extends SuperController{
    public boolean saveInventory(InventoryDetailsDTO inventoryDTO);
    public boolean updateInventory(T inventoryDTO);
    public boolean deleteInventory(ID item_code);
    public T searchInventory(ID item_code);
    public List<T> getAllInventories();
}
