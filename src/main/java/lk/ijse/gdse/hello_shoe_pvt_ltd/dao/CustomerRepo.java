package lk.ijse.gdse.hello_shoe_pvt_ltd.dao;

import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerEntity, String>{
}
