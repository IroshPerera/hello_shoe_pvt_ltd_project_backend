package lk.ijse.gdse.hello_shoe_pvt_ltd.controller.impl;

import lk.ijse.gdse.hello_shoe_pvt_ltd.controller.SuperController;
import lk.ijse.gdse.hello_shoe_pvt_ltd.controller.SupplierController;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SupplierDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/supplier")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class Supplier implements SupplierController<String,SupplierDTO> {

    private final SupplierService supplierService;

    @GetMapping("/health")
    public String healthCheck() {
        return "Hello I'm Supplier Controller. I'm OK! Have a nice day!";
    }

    @PostMapping
    public boolean saveSupplier(@RequestBody SupplierDTO supplierDTO) {
        return supplierService.add(supplierDTO);
    }

    @PutMapping
    public boolean updateSupplier(@RequestBody SupplierDTO supplierDTO) {
        return supplierService.update(supplierDTO);
    }

    @DeleteMapping
    public boolean deleteSupplier(@RequestParam String supplier_code) {
        return supplierService.delete(supplier_code);
    }

    @GetMapping
    public SupplierDTO searchSupplier(@RequestParam String supplier_code) {
        return supplierService.search(supplier_code);
    }

    @GetMapping("/all")
    public List<SupplierDTO> getAllSuppliers() {
        return supplierService.getAll();
    }

    @GetMapping("/id")
    public String generateSupplierID() {
        return supplierService.generateSupplierID();
    }

}
