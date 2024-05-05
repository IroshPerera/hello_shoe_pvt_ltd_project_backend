package lk.ijse.gdse.hello_shoe_pvt_ltd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SizeInventoryDetailsDTO implements SuperDTO{
    private Long id;
    private SizeDTO size;
    private InventoryDTO inventory;
    private String status;
    private int qty;
    private Double buying_price;
    private Double selling_price;
    private Double expected_profit;
    private Double profit_margin;
}
