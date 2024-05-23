package lk.ijse.gdse.hello_shoe_pvt_ltd.dto;

import lk.ijse.gdse.hello_shoe_pvt_ltd.util.enums.Gender;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO implements SuperDTO{
    private String customer_code;
    private String name;
    private Gender gender;
    private Date date;
    private Level level;
    private Integer point;
    private Date dob;
    private String building_number;
    private String lane;
    private String city;
    private String state;
    private String postal_code;
    private String contact;
    private String email;
    private Timestamp recent_purchase;
    private String active_state;
    private List<SaleDTO> sale = new ArrayList<>();
    private String customer_name;
}
