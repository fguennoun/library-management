package com.lampiris.library.controller;

import com.lampiris.library.domain.BookFamily;
import com.lampiris.library.domain.Library;
import com.lampiris.library.dto.BookFamilyDTO;
import com.lampiris.library.services.BookFamilyService;
import com.lampiris.library.services.LibraryService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@ApiOperation(value = "/api/v1/books-family", tags = "Book Family Controller")
@RestController
@RequestMapping("/api/v1/books-family")
public class BookFamilyController {

    private final Logger log = LoggerFactory.getLogger(BookFamilyController.class);

    private final BookFamilyService bookFamilyService;
    private final LibraryService libraryService;


    public BookFamilyController(BookFamilyService bookFamilyService, LibraryService libraryService) {
        this.bookFamilyService = bookFamilyService;
        this.libraryService = libraryService;
    }

    @PostMapping("/create")
    public ResponseEntity<BookFamily> createBook(@Valid @RequestBody BookFamilyDTO bookFamilyDTO) {
        log.debug("REST request to save Book Family : {}", bookFamilyDTO);
        BookFamily bookFamilyCreated = bookFamilyService.createBookFamily(bookFamilyDTO);
        return new ResponseEntity<>(bookFamilyCreated, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<BookFamily>> getAllBookFamily() {
        log.debug("REST request to get all Book Family");
        List<BookFamily> allBookFamily;
        allBookFamily = bookFamilyService.getAllBookFamily();
        return new ResponseEntity<>(allBookFamily, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookFamily> getBookFamilyById(@PathVariable("id") long id) {
        log.debug("REST request to get Book Family : {}", id);
        Optional<BookFamily> bookFamily = bookFamilyService.getBookFamilyById(id);
        if (bookFamily.isPresent()) {
            return new ResponseEntity<>(bookFamily.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookFamily> updateBookFamily(@PathVariable("id") Long id, @Valid @RequestBody BookFamilyDTO bookFamilyDTO) {
        log.debug("REST request to update Book Family : {}", id);
        return ResponseEntity.ok(bookFamilyService.updateBookFamily(id, bookFamilyDTO));
    }


}
