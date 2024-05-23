package lk.ijse.gdse.hello_shoe_pvt_ltd.repository;

import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepo extends JpaRepository<SupplierEntity,String> {

    @Query(value = "SELECT supplier_code FROM supplier ORDER BY supplier_code DESC LIMIT 1", nativeQuery = true)
    String generateSupplierID();


    @Override
    @Query(value = "SELECT * FROM supplier WHERE active_state = 'ACTIVE'", nativeQuery = true)
    List<SupplierEntity> findAll();

    @Modifying
    @Query(value = "UPDATE supplier SET active_state = ?1 WHERE supplier_code = ?2", nativeQuery = true)
    void changeActiveState(String deactivate, String supplierCode);

    @Query(value = "SELECT supplier_code FROM supplier WHERE name = ?1", nativeQuery = true)
    String getSupplierNameAndCode(String supplier_name);

    @Query(value = "SELECT * FROM supplier WHERE active_state = 'ACTIVE'", nativeQuery = true)
    List<SupplierEntity> getSupplier();

}
