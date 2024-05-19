package lk.ijse.gdse.hello_shoe_pvt_ltd.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "branch")
public class BranchEntity {
    @Id
    private String branch_code;
    private String branch_name;
    private String branch_manager;
    private String address;
    private String contact;
    private Integer no_of_employee;

    @OneToMany(mappedBy = "branch")
    @JsonManagedReference
    private List<EmployeeEntity> employees;
}
