package lk.ijse.gdse.hello_shoe_pvt_ltd.repository;

import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, String>{
    @Query(value = "SELECT customer_code FROM customer ORDER BY customer_code DESC LIMIT 1", nativeQuery = true)
    String generateCustomerID();

    @Modifying
    @Query(value = "UPDATE customer SET active_state = ?1 WHERE customer_code = ?2", nativeQuery = true)
    void changeActiveState(String deactivate, String customerCode);

    @Override
    @Query(value = "SELECT * FROM customer WHERE active_state = 'ACTIVE'", nativeQuery = true)
    List<CustomerEntity> findAll();
}
