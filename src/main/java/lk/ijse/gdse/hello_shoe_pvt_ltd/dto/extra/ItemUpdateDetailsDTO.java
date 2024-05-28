package lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra;

import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemUpdateDetailsDTO implements SuperDTO {
    private String item_code;
    private String item_desc;
    private String item_pic;
}
