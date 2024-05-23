package lk.ijse.gdse.hello_shoe_pvt_ltd.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SizeInventoryDetailsDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.SizeInventoryDetailsEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.repository.SizeInventoryDetailsRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.SizeInventoryDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SizeInventoryDetailsServiceIMPL implements SizeInventoryDetailsService {

    private final SizeInventoryDetailsRepo sizeInventoryDetailsRepo;

    @Override
    public boolean add(SizeInventoryDetailsDTO sizeInventoryDetailsDTO) {
        return false;
    }

    @Override
    public boolean delete(Long aLong) {
        return false;
    }

    @Override
    public boolean update(SizeInventoryDetailsDTO sizeInventoryDetailsDTO) {
        return false;
    }

    @Override
    public SizeInventoryDetailsDTO search(Long aLong) {
        return null;
    }

    @Override
    public List<SizeInventoryDetailsDTO> getAll() {
        return List.of();
    }
    @Transactional
    public void updateQty(String itemCode, String sizeCode, int qty) {

        String sizeText = "SIZE"+sizeCode;

        int currentQty = sizeInventoryDetailsRepo.findQtyByItemCodeAndSize(itemCode, sizeText);
        int newQty = currentQty + qty;
        sizeInventoryDetailsRepo.updateQty(itemCode, sizeText, newQty);
    }
}
