package com.swiz.bcs.controller;

import com.swiz.bcs.entity.Book;
import com.swiz.bcs.service.AdminBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/books")
public class AdminBookController {



        @Autowired
        private AdminBookService adminBookService;
        /*Create Bookr*/
        @PostMapping
        public Book createBook(@RequestBody Book book) {
            return adminBookService.createBook(book);
        }
        /*Delete book using Id */
        @DeleteMapping("/{id}")
        public void deleteBook(@PathVariable Integer id) {
            adminBookService.deleteBook(id);
        }

        /* Update the Book details*/
        @PutMapping("/book/{Id}")
        public ResponseEntity<String> updateBookDetails(@PathVariable Integer Id,@RequestBody Book updatedBook){
            adminBookService.updateBookDetails(Id,updatedBook);
            return ResponseEntity.ok("Book details updated successfully");
        }
        /*Get all the books*/
        @GetMapping
        public List<Book> getAllBooks() {
            return adminBookService.getAllBooks();
        }
    }


