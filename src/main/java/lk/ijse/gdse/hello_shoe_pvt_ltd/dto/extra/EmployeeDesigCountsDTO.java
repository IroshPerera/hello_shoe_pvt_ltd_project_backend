package lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra;

import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDesigCountsDTO implements SuperDTO {
    private int manager;
    private int stockKeeper;
    private int delivery;
    private int cashier;
    private int cleaner;
    private int securityGuard;

}
