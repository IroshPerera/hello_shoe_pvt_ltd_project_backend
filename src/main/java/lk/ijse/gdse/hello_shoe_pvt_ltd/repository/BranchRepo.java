package lk.ijse.gdse.hello_shoe_pvt_ltd.repository;

import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepo extends JpaRepository<BranchEntity,String> {
}
