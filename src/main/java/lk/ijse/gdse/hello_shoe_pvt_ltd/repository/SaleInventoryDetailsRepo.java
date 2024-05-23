package lk.ijse.gdse.hello_shoe_pvt_ltd.repository;

import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.SaleInventoryDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface SaleInventoryDetailsRepo extends JpaRepository<SaleInventoryDetailsEntity, String>{

    @Query(value = "SELECT COUNT(*) FROM sale_item_details WHERE order_id = ?1", nativeQuery = true)
    int countByOrderID(String orderId);

    @Modifying
    @Query(value = "UPDATE sale_item_details SET status = ?4 WHERE order_id = ?1 AND item_code = ?2 AND size = ?3", nativeQuery = true)
    void updateStatus(String orderId, String itemCode, Integer sizeCode, String returned);

    @Query(value = "SELECT * FROM sale_item_details WHERE status = 'Success'", nativeQuery = true)
    List<SaleInventoryDetailsEntity> getAll();

    @Query(value = "SELECT SUM(selling_price) FROM sale_item_details WHERE branch_code = ?1 AND status = 'Success'", nativeQuery = true)
    String getTotalSalesBranch(String branch);


    @Query(value = "SELECT SUM(selling_price) FROM sale_item_details WHERE branch_code = ?1 AND status = 'Success' AND MONTH(date) = MONTH(CURRENT_DATE()) AND YEAR(date) = YEAR(CURRENT_DATE())", nativeQuery = true)
    String getTotalSalesBranchThisMonth(String branchCode);

    @Query(value = "SELECT sale_inventory.item_code FROM sale_item_details sale_inventory JOIN inventory inventory ON sale_inventory.item_code = inventory.item_code WHERE DATE_FORMAT(sale_inventory.date, '%Y-%m') = DATE_FORMAT(CURDATE(), '%Y-%m') GROUP BY sale_inventory.item_code ORDER BY SUM(sale_inventory.item_qty) DESC LIMIT 1", nativeQuery = true)
    String findMostSoldItemThisMonth();

    @Query(value = "SELECT SUM(selling_price) FROM sale_item_details WHERE item_code = ?1 AND status = 'Success'AND MONTH(date) = MONTH(CURRENT_DATE()) AND YEAR(date) = YEAR(CURRENT_DATE())", nativeQuery = true)
    String getTotalSalesItemThisMonth(String itemCode);

    @Query(value = "SELECT sale_inventory.branch_code FROM sale_item_details sale_inventory JOIN inventory inventory ON sale_inventory.item_code = inventory.item_code WHERE DATE_FORMAT(sale_inventory.date, '%Y-%m') = DATE_FORMAT(CURDATE(), '%Y-%m') GROUP BY sale_inventory.branch_code, sale_inventory.item_code ORDER BY SUM(sale_inventory.item_qty) DESC LIMIT 1", nativeQuery = true)
    String findMostSaleBranch(String itemCode);

    @Query(value = "SELECT sale_inventory.item_code FROM sale_item_details sale_inventory JOIN inventory inventory ON sale_inventory.item_code = inventory.item_code WHERE DATE_FORMAT(sale_inventory.date, '%Y') = DATE_FORMAT(CURDATE(), '%Y') GROUP BY sale_inventory.item_code ORDER BY SUM(sale_inventory.item_qty) DESC LIMIT 1", nativeQuery = true)
    String findMostSoldItemThisYear();

    @Query(value = "SELECT SUM(selling_price) FROM sale_item_details WHERE item_code = ?1 AND status = 'Success' AND YEAR(date) = YEAR(CURRENT_DATE())", nativeQuery = true)
    String getTotalSalesItemThisYear(String itemCode);

    @Query(value = "SELECT sale_inventory.branch_code FROM sale_item_details sale_inventory JOIN inventory inventory ON sale_inventory.item_code = inventory.item_code WHERE YEAR(sale_inventory.date) = YEAR(CURDATE()) GROUP BY sale_inventory.branch_code ORDER BY SUM(sale_inventory.item_qty) DESC LIMIT 1", nativeQuery = true)
    String findMostSaleBranchThisYear(String itemCode);
}
