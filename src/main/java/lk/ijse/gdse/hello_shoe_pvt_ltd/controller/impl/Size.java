package lk.ijse.gdse.hello_shoe_pvt_ltd.controller.impl;

import lk.ijse.gdse.hello_shoe_pvt_ltd.controller.SizeController;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.SizeDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/size")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class Size implements SizeController<String, SizeDTO> {

    private final SizeService sizeService;
    @Override
    @PostMapping
    public boolean saveSize(@RequestBody SizeDTO sizeDTO) {
        return sizeService.add(sizeDTO);
    }

    @Override
    @PutMapping
    public boolean updateSize(@RequestBody SizeDTO sizeDTO) {
        return sizeService.update(sizeDTO);
    }

    @Override
    @DeleteMapping
    public boolean deleteSize(@RequestParam String size_code) {
        return sizeService.delete(size_code);
    }

    @Override
    @GetMapping
    public SizeDTO searchSize(@RequestParam String size_code) {
        return sizeService.search(size_code);
    }

    @Override
    @GetMapping("/all")
    public List<SizeDTO> getAllSizes() {
        return sizeService.getAll();
    }

    @Override
    @GetMapping("/health")
    public String healthCheck() {
       return "Hello I'm Size Controller. I'm OK! Have a nice day!";
    }
}
