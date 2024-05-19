package lk.ijse.gdse.hello_shoe_pvt_ltd.dto;

import lk.ijse.gdse.hello_shoe_pvt_ltd.util.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SupplierDTO implements SuperDTO{
    private String supplier_code;
    private String name;
    private Category category;
    private String building_number;
    private String lane;
    private String city;
    private String state;
    private String postal_code;
    private String country;
    private String mobile_contact;
    private String landline_contact;
    private String email;
    private String active_state;

}
