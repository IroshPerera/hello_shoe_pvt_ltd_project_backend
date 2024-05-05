package lk.ijse.gdse.hello_shoe_pvt_ltd.controller;

import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra.SaleDetailsDTO;

import java.util.List;

public interface SaleController <ID,T> extends SuperController{

        public boolean saveSale(SaleDetailsDTO saleDTO);
        public boolean updateSale(T saleDTO);
        public boolean deleteSale(ID order_id);
        public T searchSale(ID order_id);
        public List<T> getAllSale();
}
