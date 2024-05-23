package lk.ijse.gdse.hello_shoe_pvt_ltd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.enums.Designation;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.enums.Gender;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeEntity {
    @Id
    private String employee_code;
    private String name;
    @Lob
    @Column(name = "profile_pic", columnDefinition = "LONGTEXT")
    private String profile_pic;
    private Gender gender;
    private String status;
    private Designation designation;
    private Role role;
    private Date dob;
    private Date joined_date;
    private String building_number;
    private String lane;
    private String city;
    private String state;
    private String postal_code;
    private String contact;
    private String email;
    private String guardian_name;
    private String guardian_contact;
    @Column(name = "active_state",columnDefinition = "varchar(10) default 'ACTIVE'")
    private String active_state;

    @ManyToOne
    @JoinColumn(name = "branch_code",referencedColumnName = "branch_code")
    @JsonBackReference
    private BranchEntity branch;
}
