package lk.ijse.gdse.hello_shoe_pvt_ltd.repository;

import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.ReturnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReturnRepo extends JpaRepository<ReturnEntity,String> {

    @Query(value = "SELECT return_id FROM returnDetails ORDER BY return_id DESC LIMIT 1",nativeQuery = true)
    String findMaxReturnId();

}
