package com.lampiris.library.services.impl;

import com.lampiris.library.domain.BookFamily;
import com.lampiris.library.domain.Library;
import com.lampiris.library.dto.BookFamilyDTO;
import com.lampiris.library.repository.BookFamilyRepository;
import com.lampiris.library.services.BookFamilyService;
import com.lampiris.library.services.LibraryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookFamilyServiceImpl implements BookFamilyService {

    private final BookFamilyRepository bookFamilyRepository;
    private final LibraryService libraryService;

    public BookFamilyServiceImpl(BookFamilyRepository bookFamilyRepository, LibraryService libraryService) {
        this.bookFamilyRepository = bookFamilyRepository;
        this.libraryService = libraryService;
    }


    @Override
    public BookFamily createBookFamily(BookFamilyDTO bookFamilyDTO) {

        BookFamily bookFamily = new BookFamily();

        Library library = new Library();
        library = libraryService.getLibraryById(bookFamilyDTO.getIdLibrary()).get();

        bookFamily.setLabel(bookFamilyDTO.getLabelBookFamily());
        bookFamily.setLibrary(library);

        return bookFamilyRepository.save(bookFamily);
    }


    @Override
    public List<BookFamily> getAllBookFamily() {
        return bookFamilyRepository.findAll();
    }


    @Override
    public Optional<BookFamily> getBookFamilyById(long id) {
        return bookFamilyRepository.findById(id);
    }


    @Override
    public BookFamily updateBookFamily(Long id, BookFamilyDTO bookFamilyDTO) {

        Optional<BookFamily> bookFamilyFromDatabase = bookFamilyRepository.findById(id);

        BookFamily bookFamilyToUpdate = bookFamilyFromDatabase.get();
        bookFamilyToUpdate.setLabel(bookFamilyDTO.getLabelBookFamily());
        new Library();
        Library library = libraryService.getLibraryById(bookFamilyDTO.getIdLibrary()).get();
        bookFamilyToUpdate.setLibrary(library);

        bookFamilyRepository.save(bookFamilyToUpdate);

        return bookFamilyToUpdate;
    }

}
