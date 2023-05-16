package com.geekster.MappingPractice.controllers;

import com.geekster.MappingPractice.models.Book;
import com.geekster.MappingPractice.models.Laptop;
import com.geekster.MappingPractice.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/")
    public String addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("byPrice/{minPrice}-{maxPrice}")
    public List<Book> getBooksBasedOnPriceRange(@PathVariable Integer minPrice,@PathVariable Integer maxPrice) {
        return bookService.getBooksBasedOnPriceRange(minPrice,maxPrice);
    }

    @DeleteMapping("/byTitle/{title}")
    public void removeBookByTitle(@PathVariable String title) {
        bookService.removeBookByTitle(title);
    }

    @PutMapping("/byPrice/{price}/author/{author}")
    public String updatePriceBasedOnAuthor(@PathVariable Integer price,@PathVariable String author) {
        return bookService.updatePriceBasedOnAuthor(price,author);
    }

}
