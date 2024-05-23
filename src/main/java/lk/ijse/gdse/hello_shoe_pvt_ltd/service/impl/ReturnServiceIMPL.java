package lk.ijse.gdse.hello_shoe_pvt_ltd.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.ReturnDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.ReturnEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.repository.ReturnRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.repository.SizeInventoryDetailsRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.ReturnService;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.SaleInventoryDetailsService;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.SizeInventoryDetailsService;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.convert.Converter;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.map.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReturnServiceIMPL implements ReturnService {
    private final ReturnRepo returnRepo;
    private final Mapping mapping;
    private final Converter converter;
    private final SizeInventoryDetailsService sizeInventoryDetailsService;
    private final SaleInventoryDetailsService saleInventoryDetailsService;
    @Override
    public boolean add(List<ReturnDTO> returnDTO) {

        /*set return id and date*/

        for (ReturnDTO dto : returnDTO) {
            dto.setReturn_id(getReturnDate());
            dto.setReturn_date(new Date());
        }

        List<ReturnEntity> returnEntity = mapping.mapToReturnEntityList(returnDTO);
        returnRepo.saveAll(returnEntity);
        for (ReturnDTO dto : returnDTO) {
            sizeInventoryDetailsService.updateQty(dto.getItem_code(), dto.getSize_code(), dto.getQty());
            saleInventoryDetailsService.updateStatus(dto.getOrder_id(), dto.getItem_code(), dto.getSize_code(), "Returned");
        }
        return returnRepo.existsById(returnEntity.get(0).getReturn_id());

    }

    private String getReturnDate() {
        String return_id = returnRepo.findMaxReturnId();
        if (return_id == null) {
            return "R001";
        }
        int id = Integer.parseInt(return_id.replace("R", ""));
        id++;
        if (id < 10) {
            return "R00" + id;
        } else if (id < 100) {
            return "R0" + id;
        } else {
            return "R" + id;
        }
    }

    @Override
    public boolean add(ReturnDTO returnDTO) {
        return false;
    }

    @Override
    public boolean delete(String return_id) {
        if (returnRepo.existsById(return_id)) {
            returnRepo.deleteById(return_id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(ReturnDTO returnDTO) {
        if (returnRepo.existsById(returnDTO.getReturn_id())) {
            Optional<ReturnEntity> tmpReturn = returnRepo.findById(returnDTO.getReturn_id());
            converter.convertReturnEntity(returnDTO, tmpReturn.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ReturnDTO search(String return_id) {
        if (!returnRepo.existsById(return_id)) {
            return null;
        }
        ReturnEntity returnEntity = returnRepo.getReferenceById(return_id);
        return mapping.mapToReturnDTO(returnEntity);
    }

    @Override
    public List<ReturnDTO> getAll() {
        List<ReturnEntity> returnEntities = returnRepo.findAll();
        return mapping.mapToReturnDTOList(returnEntities);
    }
}
