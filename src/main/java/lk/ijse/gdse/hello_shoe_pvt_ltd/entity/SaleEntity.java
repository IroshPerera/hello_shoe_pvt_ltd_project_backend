package lk.ijse.gdse.hello_shoe_pvt_ltd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sale")
public class SaleEntity {
    @Id
    private String order_id;
    @ManyToOne(optional = true)
    @JoinColumn(name = "customer_code",referencedColumnName = "customer_code")
    private CustomerEntity customer;
    private double total_price;
    private Timestamp purchase_date;
    private String payment_method;
    private double added_points;
    private String cashier_name;
    private String customer_name;


}
