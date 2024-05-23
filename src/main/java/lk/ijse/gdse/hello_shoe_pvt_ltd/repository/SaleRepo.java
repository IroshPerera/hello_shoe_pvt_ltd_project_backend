package lk.ijse.gdse.hello_shoe_pvt_ltd.repository;

import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SaleRepo extends JpaRepository<SaleEntity,String> {

    @Query(value = "SELECT order_id FROM sale ORDER BY order_id DESC LIMIT 1", nativeQuery = true)
    String getLastSaleID();
}
