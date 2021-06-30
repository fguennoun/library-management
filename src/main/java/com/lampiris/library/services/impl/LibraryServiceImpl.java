package com.lampiris.library.services.impl;

import com.lampiris.library.domain.Library;
import com.lampiris.library.dto.LibraryDTO;
import com.lampiris.library.repository.LibraryRepository;
import com.lampiris.library.services.LibraryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService {

    private final LibraryRepository libraryRepository;

    public LibraryServiceImpl(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Override
    public Library createLibrary(LibraryDTO libraryDTO) {
        Library library = new Library();
        library.setLabel(libraryDTO.getLabelLibrary());
        return libraryRepository.save(library);
    }

    @Override
    public Optional<Library> getLibraryById(long id) {
        return libraryRepository.findById(id);
    }
}
