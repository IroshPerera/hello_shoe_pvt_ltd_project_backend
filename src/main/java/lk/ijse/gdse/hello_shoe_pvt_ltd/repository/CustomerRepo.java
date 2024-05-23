package lk.ijse.gdse.hello_shoe_pvt_ltd.repository;

import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, String>{
    @Query(value = "SELECT customer_code FROM customer ORDER BY customer_code DESC LIMIT 1", nativeQuery = true)
    String generateCustomerID();

    @Modifying
    @Query(value = "UPDATE customer SET active_state = ?1 WHERE customer_code = ?2", nativeQuery = true)
    void changeActiveState(String deactivate, String customerCode);

    @Override
    @Query(value = "SELECT * FROM customer WHERE active_state = 'ACTIVE'", nativeQuery = true)
    List<CustomerEntity> findAll();

    @Query(value = "SELECT * FROM customer WHERE contact = ?1", nativeQuery = true)
    CustomerEntity searchContact(String customerContact);

    @Modifying
    @Query(value = "UPDATE customer SET point = ?2 WHERE customer_code = ?1", nativeQuery = true)
    void updatePoints(String customerCode, double newPoints);

    @Modifying
    @Query(value = "UPDATE customer SET recent_purchase = ?2 WHERE customer_code = ?1", nativeQuery = true)
    void updateLastPurchaseDate(String customerCode, Timestamp purchaseDate);

    @Query(value = "SELECT COUNT(customer_code) FROM customer WHERE active_state = 'ACTIVE'", nativeQuery = true)
    String getCustomerCount();

    @Query(value = "SELECT COUNT(customer_code) FROM customer WHERE MONTH(dob) = MONTH(CURRENT_DATE()) AND DAY(dob) = DAY(CURRENT_DATE())", nativeQuery = true)
    int findTodayBirthDayCustomerCount();

    @Query(value = "SELECT * FROM customer WHERE MONTH(dob) = MONTH(CURRENT_DATE()) AND DAY(dob) = DAY(CURRENT_DATE())", nativeQuery = true)
    List<CustomerEntity> findTodayBirthDayCustomer();
}
