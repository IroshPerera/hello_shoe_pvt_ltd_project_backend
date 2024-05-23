package lk.ijse.gdse.hello_shoe_pvt_ltd.service;

import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SupplierDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra.SupplierCountDTO;

public interface SupplierService extends SuperService<String, SupplierDTO> {
    String generateSupplierID();

    String getSupplierNameAndCode(String supplier_name);

    SupplierCountDTO getSupplierCount();
}
