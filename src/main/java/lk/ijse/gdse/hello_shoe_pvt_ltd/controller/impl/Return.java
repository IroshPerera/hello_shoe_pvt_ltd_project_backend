package lk.ijse.gdse.hello_shoe_pvt_ltd.controller.impl;

import lk.ijse.gdse.hello_shoe_pvt_ltd.controller.ReturnController;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.ReturnDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.ReturnService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/return")
@RequiredArgsConstructor
public class Return implements ReturnController<String, ReturnDTO> {

    private final ReturnService returnService;


    @Override
    @PostMapping
    public boolean saveReturn(@RequestBody ReturnDTO returnDTO) {
        return returnService.add(returnDTO);
    }

    @Override
    @PutMapping
    public boolean updateReturn(@RequestBody ReturnDTO returnDTO) {
        return returnService.update(returnDTO);
    }

    @Override
    @DeleteMapping
    public boolean deleteReturn(@RequestParam String return_id) {
        return returnService.delete(return_id);
    }

    @Override
    @GetMapping
    public ReturnDTO searchReturn(@RequestParam String return_id) {
        return returnService.search(return_id);
    }

    @Override
    @GetMapping("/all")
    public List<ReturnDTO> getAllReturn() {
        return returnService.getAll();
    }

    @Override
    @GetMapping("health")
    public String healthCheck() {
        return "Hello I'm return Controller. I'm OK! Have a nice day!";
    }
}
