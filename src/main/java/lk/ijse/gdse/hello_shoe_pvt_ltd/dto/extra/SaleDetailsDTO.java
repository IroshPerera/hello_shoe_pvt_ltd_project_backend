package lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra;

import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SaleDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SaleInventoryDetailsDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaleDetailsDTO implements SuperDTO {
    private SaleDTO saleDTO;
    private List<SaleInventoryDetailsDTO> saleInventoryDetailsDTO;
}
