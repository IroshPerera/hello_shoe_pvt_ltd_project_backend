package lk.ijse.gdse.hello_shoe_pvt_ltd.controller.impl;

import lk.ijse.gdse.hello_shoe_pvt_ltd.controller.SaleController;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SaleDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra.SaleDetailsDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.SaleInventoryDetailsService;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sale")
@RequiredArgsConstructor
public class Sale implements SaleController<String, SaleDTO> {

    private final SaleService saleService;
    private final SaleInventoryDetailsService saleInventoryDetailsService;
    @Override
    @PostMapping
    public boolean saveSale(@RequestBody SaleDetailsDTO saleDetailsDTO) {
        return saleService.add(saleDetailsDTO);
    }


    @Override
    @PutMapping
    public boolean updateSale(@RequestBody SaleDTO saleDTO) {
        return saleService.update(saleDTO);
    }

    @Override
    @DeleteMapping
    public boolean deleteSale(@RequestParam String order_id) {
       return saleService.delete(order_id);
    }

    @Override
    @GetMapping
    public SaleDTO searchSale(@RequestParam String order_id) {
        return saleService.search(order_id);
    }

    @Override
    @GetMapping("/all")
    public List<SaleDTO> getAllSale() {
        return saleService.getAll();
    }

    @Override
    @GetMapping("/health")
    public String healthCheck() {
        return "Hello I'm Sale controller and I'm okay!";
    }
}
