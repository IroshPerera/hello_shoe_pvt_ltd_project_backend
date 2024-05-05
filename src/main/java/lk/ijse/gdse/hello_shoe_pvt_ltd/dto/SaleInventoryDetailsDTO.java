package lk.ijse.gdse.hello_shoe_pvt_ltd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaleInventoryDetailsDTO implements SuperDTO{

    private Long id;
    private SaleDTO sale;
    private InventoryDTO inventory;
    private int size;
    private double selling_price;
    private int item_qty;

}
