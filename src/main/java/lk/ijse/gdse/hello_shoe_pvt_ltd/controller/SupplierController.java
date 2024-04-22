package lk.ijse.gdse.hello_shoe_pvt_ltd.controller;

import java.util.List;

public interface SupplierController<ID,T> extends SuperController{
    public boolean saveSupplier(T supplierDTO);
    public boolean updateSupplier(T supplierDTO);
    public boolean deleteSupplier(ID supplier_code);
    public T searchSupplier(ID supplier_code);
    public List<T> getAllSuppliers();
}
