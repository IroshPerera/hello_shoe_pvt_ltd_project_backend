package lk.ijse.gdse.hello_shoe_pvt_ltd.service;

import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SaleDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra.SaleDetailsDTO;

public interface SaleService extends SuperService<String, SaleDTO>{
    public boolean add(SaleDetailsDTO saleDetailsDTO);
}
