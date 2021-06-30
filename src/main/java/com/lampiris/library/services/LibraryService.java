package com.lampiris.library.services;

import com.lampiris.library.domain.Library;
import com.lampiris.library.dto.LibraryDTO;

import java.util.Optional;

public interface LibraryService {

    Library createLibrary(LibraryDTO libraryDTO);

    Optional<Library> getLibraryById(long id);
}
