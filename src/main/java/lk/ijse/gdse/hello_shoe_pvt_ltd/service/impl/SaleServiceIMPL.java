package lk.ijse.gdse.hello_shoe_pvt_ltd.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SaleDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra.SaleDetailsDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.SaleEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.SaleInventoryDetailsEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.repository.SaleInventoryDetailsRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.repository.SaleRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.SaleService;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.convert.Converter;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.map.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SaleServiceIMPL implements SaleService {
    private final SaleRepo saleRepo;
    private final SaleInventoryDetailsRepo saleInventoryDetailsRepo;
    private final Mapping mapping;
    private final Converter converter;

    @Override
    public boolean add(SaleDetailsDTO saleDTO) {
        SaleEntity saleEntity = mapping.mapToSaleEntity(saleDTO.getSaleDTO());
        List<SaleInventoryDetailsEntity> saleInventoryDetailsEntities = mapping.mapToSaleDetailsDTO(saleDTO);
        saleRepo.save(saleEntity);
        saleInventoryDetailsRepo.saveAll(saleInventoryDetailsEntities);
        if (saleRepo.existsById(saleEntity.getOrder_id())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean add(SaleDTO saleDTO) {
        return false;
    }

    @Override
    public boolean delete(String order_id) {
        if (saleRepo.existsById(order_id)) {
            saleRepo.deleteById(order_id);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean update(SaleDTO saleDTO) {
        if (saleRepo.existsById(saleDTO.getOrder_id())) {
            SaleEntity saleEntity = saleRepo.getReferenceById(saleDTO.getOrder_id());
            converter.convertSaleEntity(saleDTO, saleEntity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public SaleDTO search(String order_id) {
        if (!saleRepo.existsById(order_id)) {
            return null;
        }
        SaleEntity saleEntity = saleRepo.getReferenceById(order_id);
        return mapping.mapToSaleDTO(saleEntity);

    }

    @Override
    public List<SaleDTO> getAll() {
        List<SaleEntity> saleEntities = saleRepo.findAll();
        return mapping.mapToSaleDTOList(saleEntities);
    }
}
