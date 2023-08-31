package com.swiz.bcs.service;

import com.swiz.bcs.entity.Book;
import com.swiz.bcs.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AdminBookService {
    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

//    public Book updateBook(Long bookId, Book book) {
//      if(book == null)
//      {
//          throw new IllegalArgumentException("Book not available");
//
//      }
//

 //Implementation for updating book
 //Retrieve existing book, update fields, save back
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
