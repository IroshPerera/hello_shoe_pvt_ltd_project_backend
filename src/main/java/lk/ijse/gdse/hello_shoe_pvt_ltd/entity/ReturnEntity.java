package lk.ijse.gdse.hello_shoe_pvt_ltd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="returnDetails")
public class ReturnEntity {
    @Id
    private String return_id;
    private Date return_date;
    private String reason;
    private String item_code;
    private String order_id;
    private String size;
    private Integer qty;
}
