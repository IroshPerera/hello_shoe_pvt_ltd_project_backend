package lk.ijse.gdse.hello_shoe_pvt_ltd.controller;

import java.util.List;

public interface BranchController<ID,T> extends SuperController{
    public boolean saveBranch(T branchDTO);
    public boolean updateBranch(T branchDTO);
    public boolean deleteBranch(ID branch_code);
    public T searchBranch(ID branch_code);
    public List<T> getAllBranches();
}
