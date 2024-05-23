package lk.ijse.gdse.hello_shoe_pvt_ltd.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra.SupplierCountDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.repository.SupplierRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SupplierDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.SupplierEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.SupplierService;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.convert.Converter;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.map.Mapping;
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
        supplierEntity.setActive_state("ACTIVE");
        supplierRepo.save(supplierEntity);
        return supplierRepo.existsById(supplierEntity.getSupplier_code());

    }

    @Override
    public boolean delete(String supplier_code) {
        if (supplierRepo.existsById(supplier_code)) {
            supplierRepo.changeActiveState("DEACTIVATE", supplier_code);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(SupplierDTO supplierDTO) {
       /* Optional<SupplierEntity> tmpSupplier = supplierRepo.findById(supplierDTO.getSupplier_code());
        if (tmpSupplier.isPresent()) {
            converter.convertSupplierEntity(supplierDTO, tmpSupplier.get());
            return true;
        }
        return false;*/

        supplierDTO.setActive_state("ACTIVE");
        return add(supplierDTO);
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

    @Override
    public String generateSupplierID() {
        String supplierCode = supplierRepo.generateSupplierID();
        if (supplierCode == null) {
            return "S001";
        } else {
            int num = Integer.parseInt(supplierCode.replace("S", ""));
            num++;
            if (num < 10) {
                return "S00" + num;
            } else if (num < 100) {
                return "S0" + num;
            } else {
                return "S" + num;
            }
        }
    }

    @Override
    public String getSupplierNameAndCode(String supplier_name) {
        return supplierRepo.getSupplierNameAndCode(supplier_name);
    }

    @Override
    public SupplierCountDTO getSupplierCount() {
        int total_suppliers = 0;
        int local_suppliers = 0;
        int international_suppliers = 0;

        List<SupplierEntity> allSuppliers = supplierRepo.getSupplier();

        for (SupplierEntity supplierEntity : allSuppliers) {
            total_suppliers++;
            switch (supplierEntity.getCategory()) {
                case LOCAL:
                    local_suppliers++;
                    break;
                case INTERNATIONAL:
                    international_suppliers++;
                    break;
            }
        }

        return new SupplierCountDTO(total_suppliers, local_suppliers, international_suppliers);

    }
}
