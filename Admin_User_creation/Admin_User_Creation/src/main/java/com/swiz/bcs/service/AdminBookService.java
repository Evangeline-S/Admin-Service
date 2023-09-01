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

    public void deleteBook(Integer bookId) {
        bookRepository.deleteById(bookId);
    }

    /*Update book*/
    public void updateBookDetails(Integer Id,Book updatedBook)
    {
        Book existingBook = bookRepository.findById(Id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with ID:"+Id));
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setIsbn(updatedBook.getIsbn());
        existingBook.setGenre(updatedBook.getGenre());
        existingBook.setAuthor(updatedBook.getAuthor());
     //   existingBook.setIsAvailable(updatedBook.getIsAvailable());
        bookRepository.save(existingBook);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
