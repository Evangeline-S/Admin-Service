package com.swiz.bcs.controller;

import com.swiz.bcs.entity.Book;
import com.swiz.bcs.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/books")
public class AdminBookController {

    private final BookService bookService;

    @Autowired
    public AdminBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book createBook(@RequestBody Book book, @RequestParam String adminUsername) {
        return bookService.createBook(book, adminUsername);
    }

    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable Integer bookId, @RequestBody Book updatedBook, @RequestParam String adminUsername) {
        return bookService.updateBook(bookId, updatedBook, adminUsername);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Integer bookId, @RequestParam String adminUsername) {
        bookService.deleteBook(bookId, adminUsername);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}

//        @Autowired
//        private BookService BookService;
//        /*Create Bookr*/
//        @PostMapping
//        public Book createBook(@RequestBody Book book) {
//            return BookService.createBook(book);
//        }
//        /*Delete book using Id */
//        @DeleteMapping("/{id}")
//        public void deleteBook(@PathVariable Integer id) {
//            bookService.deleteBook(id);
//        }
//
//        /* Update the Book details*/
//        @PutMapping("/book/{Id}")
//        public ResponseEntity<String> updateBookDetails(@PathVariable Integer Id,@RequestBody Book updatedBook){
//            adminBookService.updateBookDetails(Id,updatedBook);
//            return ResponseEntity.ok("Book details updated successfully");
//        }
//        /*Get all the books*/
//        @GetMapping
//        public List<Book> getAllBooks() {
//            return adminBookService.getAllBooks();
//        }
//    }


