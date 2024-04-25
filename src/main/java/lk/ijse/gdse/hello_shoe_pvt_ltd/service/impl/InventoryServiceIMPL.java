package lk.ijse.gdse.hello_shoe_pvt_ltd.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.InventoryDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.InventoryEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.repository.InventoryRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.InventoryService;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.convert.Converter;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.map.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryServiceIMPL implements InventoryService {


    private final InventoryRepo inventoryRepo;
    private final Mapping mapping;
    private final Converter converter;

    @Override
    public boolean add(InventoryDTO inventoryDTO) {

        InventoryEntity inventoryEntity = mapping.mapToInventoryEntity(inventoryDTO);
        inventoryRepo.save(inventoryEntity);
        return inventoryRepo.existsById(inventoryEntity.getItem_code());


    }

    @Override
    public boolean delete(String item_code) {
        if (inventoryRepo.existsById(item_code)) {
            inventoryRepo.deleteById(item_code);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean update(InventoryDTO inventoryDTO) {
        if (inventoryRepo.existsById(inventoryDTO.getItem_code())) {
            Optional<InventoryEntity> tmpInventory = inventoryRepo.findById(inventoryDTO.getItem_code());
            converter.convertInventoryEntity(inventoryDTO, tmpInventory.get());
            return true;
        } else {
            return false;
        }

    }

    @Override
    public InventoryDTO search(String item_code) {
        if (!inventoryRepo.existsById(item_code)) {
            return null;
        }
        InventoryEntity inventoryEntity = inventoryRepo.getReferenceById(item_code);
        return mapping.mapToInventoryDTO(inventoryEntity);

    }

    @Override
    public List<InventoryDTO> getAll() {
        List<InventoryEntity> inventoryEntityList = inventoryRepo.findAll();
        return mapping.mapToInventoryDTOList(inventoryEntityList);

    }
}
