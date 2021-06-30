package com.lampiris.library.services;

import com.lampiris.library.domain.Book;
import com.lampiris.library.dto.BookDTO;
import com.lampiris.library.dto.BookFamilyDTO;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface BookService {

    Book createBook(BookDTO bookDTO);
    List<Book> getAllBooks();
    Optional<Book> getBookById(long id);
    Book updateBook(Long id, BookDTO bookDTO);

    List<Book> exportAllBooks() throws IOException;

    Optional<Book> exportOneBooks(long id) throws IOException;
}
