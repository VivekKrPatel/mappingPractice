package com.geekster.MappingPractice.controllers;

import com.geekster.MappingPractice.models.Address;
import com.geekster.MappingPractice.models.Laptop;
import com.geekster.MappingPractice.models.Student;
import com.geekster.MappingPractice.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop")
public class LaptopController {

    @Autowired
    LaptopService laptopService;

    @PostMapping("/")
    public String addLaptop(@RequestBody Laptop laptop) {
        return laptopService.addLaptop(laptop);
    }

    @GetMapping("/all")
    public List<Laptop> getAllLaptops() {
        return laptopService.getAllLaptops();
    }

    @GetMapping("byPrice/{minPrice}-{maxPrice}")
    public List<Laptop> getLaptopsBasedOnPriceRange(@PathVariable Integer minPrice,@PathVariable Integer maxPrice) {
        return laptopService.getLaptopsBasedOnPriceRange(minPrice,maxPrice);
    }

    @DeleteMapping("/byName/{name}")
    public void removeLaptopByName(@PathVariable String name) {
        laptopService.removeLaptopByName(name);
    }

    @PutMapping("/byPrice/{price}/Brand/{brand}")
    public String updatePriceBasedOnBrand(@PathVariable Integer price,@PathVariable String brand) {
        return laptopService.updatePriceBasedOnBrand(price,brand);
    }
}
