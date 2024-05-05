package lk.ijse.gdse.hello_shoe_pvt_ltd.controller;

import java.util.List;

public interface ReturnController <ID,T> extends SuperController{

    public boolean saveReturn(T returnDTO);
    public boolean updateReturn(T returnDTO);
    public boolean deleteReturn(ID return_id);
    public T searchReturn(ID return_id);
    public List<T> getAllReturn();
}
