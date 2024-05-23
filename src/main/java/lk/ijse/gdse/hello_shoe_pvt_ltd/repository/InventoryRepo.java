package lk.ijse.gdse.hello_shoe_pvt_ltd.repository;

import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.InventoryEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.enums.Gender;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.enums.Occasion;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.enums.Verities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends JpaRepository<InventoryEntity,String> {

    @Query(value = "SELECT item_code FROM inventory WHERE item_code LIKE ?1% ORDER BY item_code DESC LIMIT 1",nativeQuery = true)
    String getLastItemCode(String codeHead);

    @Modifying
    @Query(value = "UPDATE inventory SET item_desc = :itemDesc, item_pic = :itemPic, occasion = :occasion, gender = :gender, verities = :verities, supplier_code = :supplier_code WHERE item_code = :itemCode", nativeQuery = true)
    void update(
            @Param("itemCode") String itemCode,
            @Param("itemDesc") String itemDesc,
            @Param("itemPic") String itemPic,
            @Param("occasion") Occasion occasion,
            @Param("gender") Gender gender,
            @Param("verities") Verities verities,
            @Param("supplier_code")String supplierCode);

    @Query(value = "SELECT COUNT(item_code) FROM inventory", nativeQuery = true)
    String getInventoryCount();
}
