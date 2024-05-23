package lk.ijse.gdse.hello_shoe_pvt_ltd.repository;

import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, String> {
    @Query(value = "SELECT employee_code FROM employee ORDER BY employee_code DESC LIMIT 1", nativeQuery = true)
    String getEmployeeCode();

    @Modifying
    @Query(value = "UPDATE employee SET active_state = ?1 WHERE employee_code = ?2", nativeQuery = true)
    void changeActiveState(String deactivate, String employeeCode);

    @Override
    @Query(value = "SELECT * FROM employee WHERE active_state = 'ACTIVE'", nativeQuery = true)
    List<EmployeeEntity> findAll();

    @Query(value = "SELECT branch_code FROM employee WHERE employee_code = ?1", nativeQuery = true)
    String getBranchCodeByEmployeeCode(String cashierName);
}
