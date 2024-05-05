package lk.ijse.gdse.hello_shoe_pvt_ltd.repository;

import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepo extends JpaRepository<SizeEntity,String> {
}
