package lk.ijse.gdse.hello_shoe_pvt_ltd.controller.impl;

import lk.ijse.gdse.hello_shoe_pvt_ltd.controller.SaleController;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SaleDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SaleInventoryDetailsDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra.SaleDetailsDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.extra.SaleInventoryDetailsTopDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.CustomerService;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.SaleInventoryDetailsService;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sale")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class Sale implements SaleController<String, SaleDTO> {

    private final SaleService saleService;
    private final SaleInventoryDetailsService saleInventoryDetailsService;
    private final CustomerService customerService;
    @Override
    @PostMapping
    public boolean saveSale(@RequestBody SaleDetailsDTO saleDetailsDTO) {

        customerService.updatePoints(saleDetailsDTO.getSaleDTO().getCustomer().getCustomer_code(), saleDetailsDTO.getSaleDTO().getAdded_points());
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

    @GetMapping("/saleInventory")
    public List<SaleInventoryDetailsDTO> searchSaleInventory(@RequestParam String order_id) {
        return saleService.searchSaleInventory(order_id);
    }

    @Override
    @GetMapping("/all")
    public List<SaleDTO> getAllSale() {
        return saleService.getAll();
    }

    @GetMapping("/id")
    public String generateSaleID() {
        return saleService.generateSaleID();
    }


    @Override
    @GetMapping("/health")
    public String healthCheck() {
        return "Hello I'm Sale controller and I'm okay!";
    }

    @GetMapping("/totalSalesBranches")
    public List<String> getTotalSalesBranches() {
        return saleService.getTotalSalesBranches();

    }

    @GetMapping("/totalSalesBranchesThis")
    public List<String> getTotalSalesBranchesThisMonth() {
        return saleService.getTotalSalesBranchesThisMonth();

    }

    @GetMapping("/totalSalesInventoryThis")
    public SaleInventoryDetailsTopDTO getTotalSalesInventoryThisMonth() {
        return saleService.getTotalSalesInventoryThisMonth();

    }
    @GetMapping("/totalSalesInventoryThisYear")
    public SaleInventoryDetailsTopDTO getTotalSalesInventoryThisYear() {
        return saleService.getTotalSalesInventoryThisYear();

    }
}
