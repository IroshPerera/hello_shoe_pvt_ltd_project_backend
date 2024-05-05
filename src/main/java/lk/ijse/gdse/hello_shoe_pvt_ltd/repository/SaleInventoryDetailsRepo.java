package lk.ijse.gdse.hello_shoe_pvt_ltd.repository;

import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.SaleInventoryDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SaleInventoryDetailsRepo extends JpaRepository<SaleInventoryDetailsEntity, String>{

    @Query(value = "SELECT COUNT(*) FROM sale_item_details WHERE order_id = ?1", nativeQuery = true)
    int countByOrderID(String orderId);
}
