package lk.ijse.gdse.hello_shoe_pvt_ltd.dto;


import lk.ijse.gdse.hello_shoe_pvt_ltd.util.enums.Gender;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.enums.Occasion;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.enums.Verities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InventoryDTO implements SuperDTO{
    private String item_code;
    private String item_desc;
    private String item_pic;
    private Occasion occasion;
    private Gender gender;
    private Verities verities;
    private SupplierDTO supplier;
}
