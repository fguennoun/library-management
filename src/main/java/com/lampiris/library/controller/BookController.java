package com.lampiris.library.controller;

import com.lampiris.library.domain.Book;
import com.lampiris.library.domain.BookFamily;
import com.lampiris.library.dto.BookDTO;
import com.lampiris.library.dto.BookFamilyDTO;
import com.lampiris.library.services.BookService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@ApiOperation(value = "/api/v1/books", tags = "Book Controller")
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public ResponseEntity<Book> createBook(@Valid @RequestBody BookDTO bookDTO) {

        log.debug("REST request to save Book : {}", bookDTO);
        Book bookCreated = bookService.createBook(bookDTO);
        return new ResponseEntity<>(bookCreated, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Book>> getAllBook() {
        log.debug("REST request to get all Book");
        List<Book> allBooks;
        allBooks = bookService.getAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") long id) {
        log.debug("REST request to get Book : {}", id);
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            return new ResponseEntity<>(book.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @Valid @RequestBody BookDTO bookDTO) {
        log.debug("REST request to update Book : {}", id);
        return ResponseEntity.ok(bookService.updateBook(id, bookDTO));
    }


    @GetMapping("/export-all-books")
    public ResponseEntity<List<Book>> exportAllBooks() throws IOException {
        log.debug("REST request to export all Books");
        List<Book> allBooks;
        allBooks = bookService.exportAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    @GetMapping("/export-one-book/{id}")
    public ResponseEntity<Book> exportOneBook(@PathVariable("id") long id) throws IOException {
        log.debug("REST request export one Book : {}", id);
        Optional<Book> book = bookService.exportOneBooks(id);
        if (book.isPresent()) {
            return new ResponseEntity<>(book.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
