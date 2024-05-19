package lk.ijse.gdse.hello_shoe_pvt_ltd.repository;

import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SizeRepo extends JpaRepository<SizeEntity,String> {
    @Modifying
    @Query(value = "UPDATE size SET active_state = ?1 WHERE size_code = ?2", nativeQuery = true)
    void changeActiveState(String deactivate, String sizeCode);

}
