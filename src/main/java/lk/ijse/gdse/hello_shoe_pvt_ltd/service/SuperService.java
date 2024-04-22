package lk.ijse.gdse.hello_shoe_pvt_ltd.service;

import java.util.List;

public interface SuperService <ID,T>{

    public boolean add(T t);

    public boolean delete(ID id);

    public boolean update(T t);

    public T search(ID id);

    public List<T> getAll();


}
