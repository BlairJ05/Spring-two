package com.example.Events.catering;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CateringController {

    private final CateringService cateringService;

    public CateringController(CateringService cateringService) {
        this.cateringService = cateringService;
    }


    @GetMapping("/getAll")
    public List<Catering> getAll() {
        return cateringService.getAllCaterings();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Catering> getCateringById(@PathVariable Long id) {
//        Optional<Catering> catering = cateringService.;
//    }

    @PostMapping("/createCatering")
    public void createCatering(@RequestBody Catering catering) {
        cateringService.createCatering(catering);
    }

    @PutMapping("/{id}/{foodType}")
    public void updateCatering(@PathVariable("id") Long id, @RequestBody String foodType) {
        cateringService.updateCatering(id, foodType);
    }

    @DeleteMapping("/{id}")
    public void deleteCatering(@PathVariable("id") Long id) {
        cateringService.deleteCatering(id);
    }
}
