package lk.ijse.gdse.hello_shoe_pvt_ltd.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SaleInventoryDetailsDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.SaleInventoryDetailsEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.repository.SaleInventoryDetailsRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.SaleInventoryDetailsService;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.map.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SaleInventoryDetailsServiceIMPL implements SaleInventoryDetailsService {

    private final SaleInventoryDetailsRepo saleInventoryDetailsRepo;
    private final Mapping mapping;


    @Override
    public boolean add(List<SaleInventoryDetailsDTO> saleInventoryDetailsDTO) {

       return false;


    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public boolean update(SaleInventoryDetailsDTO saleInventoryDetailsDTO) {
        return false;
    }

    @Override
    public SaleInventoryDetailsDTO search(String s) {
        return null;
    }

    @Override
    public List<SaleInventoryDetailsDTO> getAll() {
        return List.of();
    }

    @Override
    public void updateStatus(String orderId, String itemCode, String sizeCode, String returned) {
        saleInventoryDetailsRepo.updateStatus(orderId,itemCode, Integer.valueOf(sizeCode),returned);
    }
}
