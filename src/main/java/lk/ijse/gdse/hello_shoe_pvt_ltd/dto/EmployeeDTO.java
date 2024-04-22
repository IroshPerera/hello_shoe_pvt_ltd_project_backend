package lk.ijse.gdse.hello_shoe_pvt_ltd.dto;

import lk.ijse.gdse.hello_shoe_pvt_ltd.util.Gender;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDTO implements SuperDTO{

    private String employee_code;
    private String name;
    private String profile_pic;
    private Gender gender;
    private String status;
    private String designation;
    private Role role;
    private Date dob;
    private Date joined_date;
    private String branch;
    private String building_number;
    private String lane;
    private String city;
    private String state;
    private String postal_code;
    private String contact;
    private String email;
    private String guardian_name;
    private String guardian_contact;
}