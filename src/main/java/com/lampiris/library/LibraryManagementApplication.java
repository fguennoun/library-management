package com.lampiris.library;

import com.lampiris.library.dto.BookDTO;
import com.lampiris.library.dto.BookFamilyDTO;
import com.lampiris.library.dto.LibraryDTO;
import com.lampiris.library.services.BookFamilyService;
import com.lampiris.library.services.BookService;
import com.lampiris.library.services.LibraryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementApplication implements CommandLineRunner {

    private final LibraryService libraryService;
    private final BookFamilyService bookFamilyService;
    private final BookService bookService;

    public LibraryManagementApplication(LibraryService libraryService, BookFamilyService bookFamilyService, BookService bookService) {
        this.libraryService = libraryService;
        this.bookFamilyService = bookFamilyService;
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Add Data to Table Library
        LibraryDTO libraryDTO = new LibraryDTO();
        libraryDTO.setLabelLibrary("Lampiris Library");
        libraryService.createLibrary(libraryDTO);

        // Add Data to Table Book Family
        BookFamilyDTO bookFamilyDTO1 = new BookFamilyDTO();
        bookFamilyDTO1.setLabelBookFamily("Thriller");
        bookFamilyDTO1.setIdLibrary(1);
        bookFamilyService.createBookFamily(bookFamilyDTO1);

        BookFamilyDTO bookFamilyDTO2 = new BookFamilyDTO();
        bookFamilyDTO2.setLabelBookFamily("Fantasy");
        bookFamilyDTO2.setIdLibrary(1);
        bookFamilyService.createBookFamily(bookFamilyDTO2);

        BookFamilyDTO bookFamilyDTO3 = new BookFamilyDTO();
        bookFamilyDTO3.setLabelBookFamily("IT");
        bookFamilyDTO3.setIdLibrary(1);
        bookFamilyService.createBookFamily(bookFamilyDTO3);

        // Add Data to Table Book
        BookDTO bookDTO1 = new BookDTO();
        bookDTO1.setTitle("Learning Angular 8");
        bookDTO1.setIsbn("1234567890-65-23");
        bookDTO1.setAuthor("Some Author 1");
        bookDTO1.setIdBookFamily(3);
        bookService.createBook(bookDTO1);

        BookDTO bookDTO2 = new BookDTO();
        bookDTO2.setTitle("Learning Spring Boot");
        bookDTO2.setIsbn("00866543-98-27");
        bookDTO2.setAuthor("Some Author 2");
        bookDTO2.setIdBookFamily(3);
        bookService.createBook(bookDTO2);

        BookDTO bookDTO3 = new BookDTO();
        bookDTO3.setTitle("The Lord ofThe Rings");
        bookDTO3.setIsbn("10764444-09-54");
        bookDTO3.setAuthor("Some Author 3");
        bookDTO3.setIdBookFamily(2);
        bookService.createBook(bookDTO3);
    }
}
