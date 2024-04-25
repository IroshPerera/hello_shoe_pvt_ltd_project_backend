package lk.ijse.gdse.hello_shoe_pvt_ltd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventory")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InventoryEntity{
    @Id
    private String item_code;
    private String item_desc;
    private String item_pic;
    private String category;
    private Integer size;
    private String supplier_code;
    private String supplier_name;
    private Double buying_price;
    private Double selling_price;
    private Double expected_profit;
    private Double profit_margin;
    private String status;
    private Integer qty_on_hand;

}
