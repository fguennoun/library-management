package com.lampiris.library.services;

import com.lampiris.library.domain.BookFamily;
import com.lampiris.library.dto.BookFamilyDTO;

import java.util.List;
import java.util.Optional;

public interface BookFamilyService {

    List<BookFamily> getAllBookFamily();
    BookFamily createBookFamily(BookFamilyDTO bookFamilyDTO);
    BookFamily updateBookFamily(Long id, BookFamilyDTO bookFamilyDTO);
    Optional<BookFamily> getBookFamilyById(long id);
}
