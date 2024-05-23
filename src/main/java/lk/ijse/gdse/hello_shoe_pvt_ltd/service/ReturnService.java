package lk.ijse.gdse.hello_shoe_pvt_ltd.service;

import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.ReturnDTO;

import java.util.List;

public interface ReturnService extends SuperService<String, ReturnDTO>{
    boolean add(List<ReturnDTO> returnDTO) ;
}
