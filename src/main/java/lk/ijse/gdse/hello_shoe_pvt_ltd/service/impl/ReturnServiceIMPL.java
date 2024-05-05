package lk.ijse.gdse.hello_shoe_pvt_ltd.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.ReturnDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.ReturnEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.repository.ReturnRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.repository.SizeInventoryDetailsRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.ReturnService;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.SizeInventoryDetailsService;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.convert.Converter;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.map.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    @Override
    public boolean add(ReturnDTO returnDTO) {
        ReturnEntity returnEntity = mapping.mapToReturnEntity(returnDTO);
        returnRepo.save(returnEntity);
        sizeInventoryDetailsService.updateQty(returnDTO.getItem_code(), returnDTO.getSize_code(), returnDTO.getQty());
        return returnRepo.existsById(returnEntity.getReturn_id());

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
