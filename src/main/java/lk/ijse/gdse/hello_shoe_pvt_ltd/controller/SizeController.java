package lk.ijse.gdse.hello_shoe_pvt_ltd.controller;

import java.util.List;

public interface SizeController <ID,T> extends SuperController {
    public boolean saveSize(T sizeDTO);
    public boolean updateSize(T sizeDTO);
    public boolean deleteSize(ID size_id);
    public T searchSize(ID size_id);
    public List<T> getAllSizes();

}
