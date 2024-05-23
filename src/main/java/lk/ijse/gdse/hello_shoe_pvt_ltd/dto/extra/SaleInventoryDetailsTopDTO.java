package lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra;

import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaleInventoryDetailsTopDTO implements SuperDTO {

    private String inventory_pic;
    private String description;
    private String branch;
    private String total_sale;

}
