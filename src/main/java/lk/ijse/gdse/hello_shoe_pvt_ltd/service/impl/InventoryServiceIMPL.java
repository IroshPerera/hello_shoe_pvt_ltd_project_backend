package lk.ijse.gdse.hello_shoe_pvt_ltd.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.InventoryDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SizeInventoryDetailsDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra.InventoryDetailsDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.InventoryEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.SizeInventoryDetailsEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.repository.InventoryRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.repository.SizeInventoryDetailsRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.InventoryService;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.convert.Converter;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.enums.Gender;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.enums.Occasion;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.map.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryServiceIMPL implements InventoryService {


    private final InventoryRepo inventoryRepo;
    private final SizeInventoryDetailsRepo sizeInventoryDetailsRepo;
    private final Mapping mapping;
    private final Converter converter;

    @Override
    public boolean add(InventoryDetailsDTO inventoryDetailsDTO) {


        InventoryEntity inventoryEntity = mapping.mapToInventoryEntity(inventoryDetailsDTO.getInventoryDTO());
        String item_code = generateItemCode(inventoryEntity);
        inventoryEntity.setItem_code(item_code);

        List<SizeInventoryDetailsEntity> sizeInventoryDetailsEntities = mapping.mapToSizeInventoryDetailsEntity(inventoryDetailsDTO.getSizeInventoryDetailsDTO());

        for (SizeInventoryDetailsEntity sizeInventoryDetailsEntity : sizeInventoryDetailsEntities) {
            sizeInventoryDetailsEntity.setItem_code(inventoryEntity);
        }

        System.out.println("inventoryEntity = " + inventoryEntity);
        System.out.println("sizeInventoryDetailsEntities = " + sizeInventoryDetailsEntities);

        inventoryRepo.save(inventoryEntity);
        sizeInventoryDetailsRepo.saveAll(sizeInventoryDetailsEntities);

        if (inventoryRepo.existsById(inventoryEntity.getItem_code())) {
            return true;
        } else {
            return false;
        }


    }

    @Override
    public boolean update(List<SizeInventoryDetailsDTO> inventoryDetailsDTO) {
        if (inventoryDetailsDTO.size() == 0) {
            return false;
        }

        /*delete first already add and now not*/

        List<SizeInventoryDetailsEntity> allSizeDetails = sizeInventoryDetailsRepo.findAll();
        List<SizeInventoryDetailsDTO> sizeInventoryDetailsDTOS = new ArrayList<>();

        for (SizeInventoryDetailsEntity sizeInventoryDetailsEntity : allSizeDetails) {
            if (sizeInventoryDetailsEntity.getItem_code().getItem_code().equals(inventoryDetailsDTO.get(0).getInventory().getItem_code())) {
                boolean isExist = false;
                for (SizeInventoryDetailsDTO sizeInventoryDetailsDTO : inventoryDetailsDTO) {
                    if (sizeInventoryDetailsEntity.getSize_code().getSize_code().equals(sizeInventoryDetailsDTO.getSize().getSize_code())) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    sizeInventoryDetailsRepo.delete(sizeInventoryDetailsEntity.getItem_code().getItem_code(), sizeInventoryDetailsEntity.getSize_code().getSize_code());
                }
            }
        }


        for (SizeInventoryDetailsDTO sizeInventoryDetailsDTO : inventoryDetailsDTO) {
            int count = sizeInventoryDetailsRepo.findExist(sizeInventoryDetailsDTO.getInventory().getItem_code(), sizeInventoryDetailsDTO.getSize().getSize_code());
            if (count == 0) {
                SizeInventoryDetailsEntity sizeInventoryDetailsEntity = mapping.mapToSizeInventoryDetailEntity(sizeInventoryDetailsDTO);
                sizeInventoryDetailsRepo.save(sizeInventoryDetailsEntity);
            } else {
                sizeInventoryDetailsRepo.updateDetails(
                        sizeInventoryDetailsDTO.getInventory().getItem_code(),
                        sizeInventoryDetailsDTO.getSize().getSize_code(),
                        sizeInventoryDetailsDTO.getQty(),
                        sizeInventoryDetailsDTO.getBuying_price(),
                        sizeInventoryDetailsDTO.getSelling_price(),
                        sizeInventoryDetailsDTO.getProfit_margin(),
                        sizeInventoryDetailsDTO.getExpected_profit());
            }
        }


        return true;
    }

    @Override
    public List<SizeInventoryDetailsDTO> getSizeDetails(String itemCode) {
//        return sizeInventoryDetailsRepo.getSizeDetails(itemCode);
        List<SizeInventoryDetailsEntity> allSizeDetails = sizeInventoryDetailsRepo.findAll();
        List<SizeInventoryDetailsDTO> sizeInventoryDetailsDTOS = new ArrayList<>();

        for (SizeInventoryDetailsEntity sizeInventoryDetailsEntity : allSizeDetails) {
            if (sizeInventoryDetailsEntity.getItem_code().getItem_code().equals(itemCode)) {
                SizeInventoryDetailsDTO sizeInventoryDetailsDTO = mapping.mapToSizeInventoryDetailsDTO(sizeInventoryDetailsEntity);
                sizeInventoryDetailsDTOS.add(sizeInventoryDetailsDTO);
            }
        }

        return sizeInventoryDetailsDTOS;

    }

    @Override
    public String getInventoryCount() {
        return inventoryRepo.getInventoryCount();
    }

    private String generateItemCode(InventoryEntity inventoryEntity) {
        Gender gender = inventoryEntity.getGender();
        Occasion occasion = inventoryEntity.getOccasion();

        String gender_code = gender == Gender.MALE ? "M" : "F";
        String occasion_code = occasion == Occasion.FORMAL ? "FS" : occasion == Occasion.CASUAL ? "CS" : occasion == Occasion.INDUSTRIAL ? "IS" : "SS";

        String code_head = occasion_code + gender_code;

        String last_item_code = inventoryRepo.getLastItemCode(code_head);

        if (last_item_code == null) {
            return code_head + "0001";
        } else {
            int new_code = Integer.parseInt(last_item_code.substring(3)) + 1;
            if (new_code < 10) {
                return code_head + "000" + new_code;
            } else if (new_code < 100) {
                return code_head + "00" + new_code;
            } else if (new_code < 1000) {
                return code_head + "0" + new_code;
            } else {
                return code_head + new_code;
            }
        }


    }

    @Override
    public boolean add(InventoryDTO inventoryDTO) {
        return false;
    }

    @Override
    public boolean delete(String item_code) {
        sizeInventoryDetailsRepo.delete(item_code);
        inventoryRepo.deleteById(item_code);
        return !inventoryRepo.existsById(item_code);

    }

    @Override
    public boolean update(InventoryDTO inventoryDTO) {

        return false;


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
