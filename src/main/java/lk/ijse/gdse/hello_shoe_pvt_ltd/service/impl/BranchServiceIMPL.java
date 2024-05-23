package lk.ijse.gdse.hello_shoe_pvt_ltd.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.BranchDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.BranchEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.repository.BranchRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.BranchService;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.convert.Converter;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.map.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BranchServiceIMPL implements BranchService {

    private final BranchRepo branchRepo;
    private final Mapping mapping;
    private final Converter converter;

    @Override
    public boolean add(BranchDTO branchDTO) {
        BranchEntity branchEntity = mapping.mapToBranchEntity(branchDTO);
        branchRepo.save(branchEntity);
        return branchRepo.existsById(branchEntity.getBranch_code());
    }

    @Override
    public boolean delete(String branch_code) {
        if (branchRepo.existsById(branch_code)) {
            branchRepo.deleteById(branch_code);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean update(BranchDTO branchDTO) {
        Optional<BranchEntity> tmpBranch = branchRepo.findById(branchDTO.getBranch_code());
        if (tmpBranch.isPresent()) {
            converter.convertBranchEntity(branchDTO, tmpBranch.get());
            return true;
        }
        return false;
    }

    @Override
    public BranchDTO search(String branch_code) {


        BranchEntity branchEntity = branchRepo.getReferenceById(branch_code);
        return mapping.mapToBranchDTO(branchEntity);

    }

    @Override
    public List<BranchDTO> getAll() {
        List<BranchEntity> branches = branchRepo.findAll();
        return mapping.mapToBranchDTOList(branches);
    }

    @Override
    public String getBranchCode() {
        String branch_code =  branchRepo.getBranchCode();
        if (branch_code == null) {
            return "B001";
        } else {
            int num = Integer.parseInt(branch_code.substring(1));
            num++;
            if (num < 10) {
                return "B00" + num;
            } else if (num < 100) {
                return "B0" + num;
            } else {
                return "B" + num;
            }
        }
    }

    @Override
    public String getBranchName(String branchCode) {
        return branchRepo.getBranchName(branchCode);
    }
}
