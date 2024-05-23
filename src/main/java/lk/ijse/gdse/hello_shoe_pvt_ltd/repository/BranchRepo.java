package lk.ijse.gdse.hello_shoe_pvt_ltd.repository;

import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepo extends JpaRepository<BranchEntity,String> {

    @Query(value = "SELECT branch_code FROM branch ORDER BY branch_code DESC LIMIT 1", nativeQuery = true)
    String getBranchCode();

    @Query(value = "SELECT branch_name FROM branch WHERE branch_code = ?1", nativeQuery = true)
    String getBranchName(String branchCode);
}
