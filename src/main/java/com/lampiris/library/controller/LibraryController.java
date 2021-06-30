package com.lampiris.library.controller;

import com.lampiris.library.domain.Library;
import com.lampiris.library.dto.LibraryDTO;
import com.lampiris.library.services.LibraryService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@ApiOperation(value = "/api/v1/library", tags = "Library Controller")
@RestController
@RequestMapping("/api/v1/library")
public class LibraryController {

    private final Logger log = LoggerFactory.getLogger(LibraryController.class);

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/create")
    public ResponseEntity<Library> createBook(@Valid @RequestBody LibraryDTO libraryDTO) {

        log.debug("REST request to save Library : {}", libraryDTO);
        Library libraryCreated = libraryService.createLibrary(libraryDTO);
        return new ResponseEntity<>(libraryCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Library> getLibraryById(@PathVariable("id") long id) {
        log.debug("REST request to get Library : {}", id);
        Optional<Library> library = libraryService.getLibraryById(id);
        if (library.isPresent()) {
            return new ResponseEntity<>(library.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
