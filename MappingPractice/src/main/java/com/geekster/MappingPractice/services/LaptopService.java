package com.geekster.MappingPractice.services;

import com.geekster.MappingPractice.models.Laptop;
import com.geekster.MappingPractice.models.Student;
import com.geekster.MappingPractice.repositories.ILaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    @Autowired
    ILaptopRepo iLaptopRepo;

    public String addLaptop(Laptop laptop) {
        Laptop isAdded = iLaptopRepo.save(laptop);

        if(isAdded != null){
            return "Added laptop successfully..!!!";
        }
        return "failed to add..!!!";
    }

    public List<Laptop> getAllLaptops() {
        return iLaptopRepo.findAll();
    }

    public List<Laptop> getLaptopsBasedOnPriceRange(Integer minPrice, Integer maxPrice) {
        return iLaptopRepo.findByPriceBetween(minPrice,maxPrice);
    }

    public void removeLaptopByName(String name) {
        iLaptopRepo.deleteByName(name);
    }

    public String updatePriceBasedOnBrand(Integer price, String brand) {

        Laptop laptop = iLaptopRepo.findByBrand(brand);

        if(laptop == null){
            return "This brand product is not available now.";
        }
        laptop.setPrice(price);
        iLaptopRepo.save(laptop);
        return "updated price for "+brand;
    }
}
