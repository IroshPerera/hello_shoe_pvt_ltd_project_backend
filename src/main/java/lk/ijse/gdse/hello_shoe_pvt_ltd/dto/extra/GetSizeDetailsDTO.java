package lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra;

import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetSizeDetailsDTO implements SuperDTO {
    private String id;
    private String size;
    private String inventory;
    private String status;
    private String qty;
    private String buying_price;
    private String selling_price;
    private String expected_profit;
    private String profit_margin;




}
