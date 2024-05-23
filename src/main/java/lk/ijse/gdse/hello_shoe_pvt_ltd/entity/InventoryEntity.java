package lk.ijse.gdse.hello_shoe_pvt_ltd.entity;

import jakarta.persistence.*;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.enums.Gender;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.enums.Occasion;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.enums.Verities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "inventory")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InventoryEntity{
    @Id
    private String item_code;
    private String item_desc;
    @Lob
    @Column(name = "item_pic", columnDefinition = "LONGTEXT")
    private String item_pic;
    private Occasion occasion;
    private Gender gender;
    private Verities verities;
    @ManyToOne
    @JoinColumn(name = "supplier_code", referencedColumnName = "supplier_code")
    private SupplierEntity supplier;



}
