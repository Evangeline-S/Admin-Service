package com.swiz.bcs.service;

import com.swiz.bcs.entity.Book;
import com.swiz.bcs.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service

public class BookService {
    @Autowired
    private BookRepository bookRepository;
    private final AuditLogService auditLogService;

    @Autowired
    public BookService(BookRepository bookRepository, AuditLogService auditLogService) {
        this.bookRepository = bookRepository;
        this.auditLogService = auditLogService;
    }


    public Book createBook(Book book, String adminUsername) {
        Book createdBook = bookRepository.save(book);

        // Log the book creation action
        auditLogService.logAdminAction(adminUsername, "Create Book", createdBook.getId(),"Book");

        return createdBook;
    }


    public Book updateBook(Integer bookId, Book updatedBook, String adminUsername) {
        // Check if the book with the specified ID exists
        if (!bookRepository.existsById(bookId)) {
            throw new EntityNotFoundException("Book not found with ID: " + bookId);
        }

        updatedBook.setId(bookId);
        Book savedBook = bookRepository.save(updatedBook);

        // Log the book update action
        auditLogService.logAdminAction(adminUsername, "Update Book", savedBook.getId(),"Book");

        return savedBook;
    }


    public void deleteBook(Integer bookId, String adminUsername) {
        bookRepository.deleteById(bookId);

        // Log the book deletion action
        auditLogService.logAdminAction(adminUsername, "Delete Book", bookId,"Book");
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}

//    public Book createBook(Book book) {
//        return bookRepository.save(book);
//    }
//
//    public void deleteBook(Integer bookId) {
//        bookRepository.deleteById(bookId);
//    }
//
//    /*Update book*/
//    public void updateBookDetails(Integer Id,Book updatedBook)
//    {
//        Book existingBook = bookRepository.findById(Id)
//                .orElseThrow(() -> new IllegalArgumentException("Book not found with ID:"+Id));
//        existingBook.setTitle(updatedBook.getTitle());
//        existingBook.setIsbn(updatedBook.getIsbn());
//        existingBook.setGenre(updatedBook.getGenre());
//        existingBook.setAuthor(updatedBook.getAuthor());
//     //   existingBook.setIsAvailable(updatedBook.getIsAvailable());
//        bookRepository.save(existingBook);
//    }
//
//    public List<Book> getAllBooks() {
//        return bookRepository.findAll();
//    }

