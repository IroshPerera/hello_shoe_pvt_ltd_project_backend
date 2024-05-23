package lk.ijse.gdse.hello_shoe_pvt_ltd.repository;

import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SizeInventoryDetailsDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra.GetSizeDetailsDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra.InventoryDetailsDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.SizeInventoryDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SizeInventoryDetailsRepo extends JpaRepository<SizeInventoryDetailsEntity, Long> {

    @Query(value = "SELECT qty FROM size_inventory_details WHERE item_code = :itemCode AND size_code = :size", nativeQuery = true)
    int findQtyByItemCodeAndSize(@Param("itemCode") String itemCode, @Param("size") String size);

    @Modifying
    @Query(value = "UPDATE size_inventory_details SET qty = :newQty WHERE item_code = :itemCode AND size_code = :size", nativeQuery = true)
    void updateQty(@Param("itemCode") String itemCode, @Param("size") String size, @Param("newQty") int newQty);

    @Modifying
    @Query(value = "DELETE FROM size_inventory_details WHERE item_code = :itemCode", nativeQuery = true)
    void delete(String itemCode);


    @Query(value = "SELECT COUNT(*) FROM size_inventory_details WHERE item_code = :itemCode AND size_code = :sizeCode", nativeQuery = true)
    int findExist(String itemCode, String sizeCode);

    @Modifying
    @Query(value = "UPDATE size_inventory_details SET buying_price = :buyingPrice, selling_price = :sellingPrice, profit_margin = :profitMargin, expected_profit = :expectedProfit , qty = :qty WHERE item_code = :itemCode AND size_code = :sizeCode", nativeQuery = true)
    void updateDetails(
            @Param("itemCode") String itemCode,
            @Param("sizeCode") String sizeCode,
            @Param("qty") Integer qty,
            @Param("buyingPrice") Double buyingPrice,
            @Param("sellingPrice") Double sellingPrice,
            @Param("profitMargin") Double profitMargin,
            @Param("expectedProfit") Double expectedProfit);

    @Modifying
    @Query(value = "DELETE FROM size_inventory_details WHERE item_code = :itemCode AND size_code = :sizeCode", nativeQuery = true)
    void delete(String itemCode, String sizeCode);

    @Modifying
    @Query(value = "UPDATE size_inventory_details SET qty = :newQty WHERE item_code = :itemCode AND size_code = :size", nativeQuery = true)
    void decreaseQty(@Param("itemCode") String itemCode, @Param("size") String size, @Param("newQty") int newQty);
}