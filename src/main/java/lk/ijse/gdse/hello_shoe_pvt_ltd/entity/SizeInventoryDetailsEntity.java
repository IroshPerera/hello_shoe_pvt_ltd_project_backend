package lk.ijse.gdse.hello_shoe_pvt_ltd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "size_inventory_details")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SizeInventoryDetailsEntity {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "size_code", referencedColumnName = "size_code")
    private SizeEntity size_code;

    @ManyToOne
    @JoinColumn(name = "item_code", referencedColumnName = "item_code")
    private InventoryEntity item_code;

    private String status;
    private int qty;
    private Double buying_price;
    private Double selling_price;
    private Double expected_profit;
    private Double profit_margin;
}
