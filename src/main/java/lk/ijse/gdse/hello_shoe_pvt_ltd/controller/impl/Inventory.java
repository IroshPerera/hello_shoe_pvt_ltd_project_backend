package lk.ijse.gdse.hello_shoe_pvt_ltd.controller.impl;

import lk.ijse.gdse.hello_shoe_pvt_ltd.controller.InventoryController;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.InventoryDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class Inventory implements InventoryController<String, InventoryDTO> {

    private final InventoryService inventoryService;

    @Override
    @GetMapping("/health")
    public String healthCheck() {
        return "Hello I'm Inventory Controller. I'm OK! Have a nice day!";
    }

    @Override
    @PostMapping
    public boolean saveInventory(@RequestBody InventoryDTO inventoryDTO) {
        return inventoryService.add(inventoryDTO);
    }

    @Override
    @PutMapping
    public boolean updateInventory(@RequestBody InventoryDTO inventoryDTO) {
        return inventoryService.update(inventoryDTO);
    }

    @Override
    @DeleteMapping
    public boolean deleteInventory(@RequestParam String item_code) {
        return inventoryService.delete(item_code);
    }

    @Override
    @GetMapping
    public InventoryDTO searchInventory(@RequestParam String item_code) {
        return inventoryService.search(item_code);
    }

    @Override
    @GetMapping("/all")
    public List<InventoryDTO> getAllInventories() {
        return inventoryService.getAll();
    }


}
