package com.geekster.MappingPractice.services;

import com.geekster.MappingPractice.models.Book;
import com.geekster.MappingPractice.models.Laptop;
import com.geekster.MappingPractice.repositories.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    IBookRepo iBookRepo;

    public String addBook(Book book) {
        Book isAdded = iBookRepo.save(book);

        if(isAdded != null){
            return "Added Book successfully..!!!";
        }
        return "failed to add..!!!";
    }

    public List<Book> getAllBooks() {
        return iBookRepo.findAll();
    }

    public List<Book> getBooksBasedOnPriceRange(Integer minPrice, Integer maxPrice) {
        return iBookRepo.findByPriceBetween(minPrice,maxPrice);
    }

    public void removeBookByTitle(String title) {
        iBookRepo.deleteByTitle(title);
    }

    public String updatePriceBasedOnAuthor(Integer price, String author) {
        Book book = iBookRepo.findByAuthor(author);

        if(book == null){
            return "This Book is not available now.";
        }
        book.setPrice(price);
        iBookRepo.save(book);
        return "updated price for "+author;
    }
}
