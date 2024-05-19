package lk.ijse.gdse.hello_shoe_pvt_ltd.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SizeDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.SizeEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.repository.SizeRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.SizeService;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.convert.Converter;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.map.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SizeServiceIMPL implements SizeService {
    private final SizeRepo sizeRepo;
    private final Mapping mapping;
    private final Converter converter;
    @Override
    public boolean add(SizeDTO sizeDTO) {
        SizeEntity sizeEntity = mapping.mapToSizeEntity(sizeDTO);
        sizeRepo.save(sizeEntity);
        return sizeRepo.existsById(sizeEntity.getSize_code());

    }

    @Override
    public boolean delete(String size_code) {
        if (sizeRepo.existsById(size_code)) {
            sizeRepo.deleteById(size_code);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(SizeDTO sizeDTO) {
       /* if (sizeRepo.existsById(sizeDTO.getSize_code())) {
            SizeEntity sizeEntity = sizeRepo.getReferenceById(sizeDTO.getSize_code());
            converter.convertSizeEntity(sizeDTO, sizeEntity);
            return true;
        } else {
            return false;
        }*/
        return add(sizeDTO);

    }

    @Override
    public SizeDTO search(String size_id) {

        if (!sizeRepo.existsById(size_id)) {
            return null;
        }
        SizeEntity sizeEntity = sizeRepo.getReferenceById(size_id);
        return mapping.mapToSizeDTO(sizeEntity);
    }

    @Override
    public List<SizeDTO> getAll() {
        List<SizeEntity> sizeEntities = sizeRepo.findAll();
        return mapping.mapToSizeDTOList(sizeEntities);

    }
}
