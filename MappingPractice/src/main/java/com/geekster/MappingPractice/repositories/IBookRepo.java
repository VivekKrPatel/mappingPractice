package com.geekster.MappingPractice.repositories;

import com.geekster.MappingPractice.models.Book;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface IBookRepo extends ListCrudRepository<Book,Long> {
    List<Book> findByPriceBetween(Integer minPrice, Integer maxPrice);

    void deleteByTitle(String title);

    Book findByAuthor(String author);
}
