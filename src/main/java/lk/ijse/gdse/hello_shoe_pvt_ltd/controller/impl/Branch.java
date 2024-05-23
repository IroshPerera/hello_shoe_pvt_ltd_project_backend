package lk.ijse.gdse.hello_shoe_pvt_ltd.controller.impl;

import lk.ijse.gdse.hello_shoe_pvt_ltd.controller.BranchController;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.BranchDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.repository.BranchRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/branch")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class Branch implements BranchController<String, BranchDTO> {

    private final BranchService branchService;


    @Override
    @PostMapping
    public boolean saveBranch(@RequestBody BranchDTO branchDTO) {
        return branchService.add(branchDTO);
    }

    @Override
    @PutMapping
    public boolean updateBranch(@RequestBody BranchDTO branchDTO) {
        return branchService.update(branchDTO);
    }

    @Override
    @DeleteMapping
    public boolean deleteBranch(@RequestParam String branch_code) {
        return branchService.delete(branch_code);
    }

    @Override
    @GetMapping
    public BranchDTO searchBranch(@RequestParam String branch_code) {
        try {

            return branchService.search(branch_code);
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    @GetMapping("/all")
    public List<BranchDTO> getAllBranches() {
        return branchService.getAll();
    }

    @Override
    @GetMapping("/health")
    public String healthCheck() {
        return "Hello I'm Branch Controller. I'm OK! Have a nice day!";
    }

    @GetMapping("/id")
    public String getBranchId() {
        return branchService.getBranchCode();
    }
}
