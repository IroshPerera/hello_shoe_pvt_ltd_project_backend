package lk.ijse.gdse.hello_shoe_pvt_ltd.dao;

import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, String>{
}
