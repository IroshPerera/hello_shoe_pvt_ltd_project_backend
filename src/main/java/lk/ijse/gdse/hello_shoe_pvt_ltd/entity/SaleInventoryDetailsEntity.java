package lk.ijse.gdse.hello_shoe_pvt_ltd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sale_item_details")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaleInventoryDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private SaleEntity sale;

    @ManyToOne
    @JoinColumn(name = "item_code", referencedColumnName = "item_code")
    private InventoryEntity inventory;
    private int size;
    private int item_qty;
    private Double selling_price;
    private String status;
    private String branch_code;
    private Date date;
}
