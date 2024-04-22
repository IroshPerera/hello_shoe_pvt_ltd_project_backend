package lk.ijse.gdse.hello_shoe_pvt_ltd.repository;

import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SupplierRepo extends JpaRepository<SupplierEntity,String> {
}
