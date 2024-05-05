package lk.ijse.gdse.hello_shoe_pvt_ltd.repository;

import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.SizeInventoryDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeInventoryDetailsRepo extends JpaRepository<SizeInventoryDetailsEntity, Long> {

    @Query(value = "SELECT qty FROM size_inventory_details WHERE item_code = :itemCode AND size_code = :size", nativeQuery = true)
    int findQtyByItemCodeAndSize(@Param("itemCode") String itemCode, @Param("size") String size);

    @Modifying
    @Query(value = "UPDATE size_inventory_details SET qty = :newQty WHERE item_code = :itemCode AND size_code = :size", nativeQuery = true)
    void updateQty(@Param("itemCode") String itemCode, @Param("size") String size, @Param("newQty") int newQty);
}