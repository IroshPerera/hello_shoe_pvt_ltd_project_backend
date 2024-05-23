package lk.ijse.gdse.hello_shoe_pvt_ltd.service;

import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.BranchDTO;

public interface BranchService extends SuperService<String, BranchDTO>{
    String getBranchCode();


    String getBranchName(String branchCode);
}
