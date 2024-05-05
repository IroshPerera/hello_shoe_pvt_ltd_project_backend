package lk.ijse.gdse.hello_shoe_pvt_ltd.service;

import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SizeInventoryDetailsDTO;

public interface SizeInventoryDetailsService extends SuperService<Long, SizeInventoryDetailsDTO> {

  void updateQty(String item_code, String size_code,int qty);
}
