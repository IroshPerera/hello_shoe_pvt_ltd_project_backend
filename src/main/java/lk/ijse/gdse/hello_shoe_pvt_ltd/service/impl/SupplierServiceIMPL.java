package lk.ijse.gdse.hello_shoe_pvt_ltd.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dao.SupplierRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SupplierDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.SupplierEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.SupplierService;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.Converter;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SupplierServiceIMPL implements SupplierService {

    private final SupplierRepo supplierRepo;
    private final Mapping mapping;
    private final Converter converter;

    @Override
    public boolean add(SupplierDTO supplierDTO) {

        SupplierEntity supplierEntity = mapping.mapToSupplierEntity(supplierDTO);
        supplierRepo.save(supplierEntity);
        return supplierRepo.existsById(supplierEntity.getSupplier_code());

    }

    @Override
    public boolean delete(String supplier_code) {
        if (supplierRepo.existsById(supplier_code)) {
            supplierRepo.deleteById(supplier_code);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(SupplierDTO supplierDTO) {
        Optional<SupplierEntity> tmpSupplier = supplierRepo.findById(supplierDTO.getSupplier_code());
        if (tmpSupplier.isPresent()) {
            converter.convertSupplierEntity(supplierDTO, tmpSupplier.get());
            return true;
        }
        return false;
    }

    @Override
    public SupplierDTO search(String supplier_code) {
        SupplierEntity referenceSupplierEntity = supplierRepo.getReferenceById(supplier_code);
        return mapping.mapToSupplierDTO(referenceSupplierEntity);
    }

    @Override
    public List<SupplierDTO> getAll() {
        return mapping.mapToSupplierDTOList(supplierRepo.findAll());
    }
}
