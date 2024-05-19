package lk.ijse.gdse.hello_shoe_pvt_ltd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "supplier")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SupplierEntity {
    @Id
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

    @OneToMany(mappedBy = "supplier")
    private List<InventoryEntity> inventories;
}
