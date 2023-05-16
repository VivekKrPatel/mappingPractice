package com.geekster.MappingPractice.repositories;

import com.geekster.MappingPractice.models.Laptop;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ILaptopRepo extends ListCrudRepository<Laptop,Long> {
    List<Laptop> findByPriceBetween(Integer minPrice, Integer maxPrice);

    void deleteByName(String name);

    Laptop findByBrand(String brand);
}
