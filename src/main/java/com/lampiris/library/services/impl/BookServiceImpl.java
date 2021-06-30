package com.lampiris.library.services.impl;

import com.lampiris.library.domain.Book;
import com.lampiris.library.domain.BookFamily;
import com.lampiris.library.dto.BookDTO;
import com.lampiris.library.repository.BookRepository;
import com.lampiris.library.services.BookFamilyService;
import com.lampiris.library.services.BookService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private static final String ALL_BOOKS_EXPORTED = "all-books.txt";
    private static final String ONE_BOOK_EXPORTED = "one-book.txt";

    private final BookRepository bookRepository;
    private final BookFamilyService bookFamilyService;

    public BookServiceImpl(BookRepository bookRepository, BookFamilyService bookFamilyService) {
        this.bookRepository = bookRepository;
        this.bookFamilyService = bookFamilyService;
    }


    @Override
    public Book createBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book.setTitle(bookDTO.getTitle());
        new BookFamily();
        BookFamily bookFamily = bookFamilyService.getBookFamilyById(bookDTO.getIdBookFamily()).get();
        book.setBookFamily(bookFamily);
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book updateBook(Long id, BookDTO bookDTO) {
        Optional<Book> bookFromDatabase = bookRepository.findById(id);

        Book bookToUpdate = bookFromDatabase.get();
        bookToUpdate.setTitle(bookDTO.getTitle());
        bookToUpdate.setIsbn(bookDTO.getIsbn());
        bookToUpdate.setAuthor(bookDTO.getAuthor());

        new BookFamily();
        BookFamily bookFamily = bookFamilyService.getBookFamilyById(bookDTO.getIdBookFamily()).get();
        bookToUpdate.setBookFamily(bookFamily);

        bookRepository.save(bookToUpdate);

        return bookToUpdate;
    }

    @Override
    public List<Book> exportAllBooks() throws IOException {

        List<Book> exportedBooks = bookRepository.findAll();

        for(Book book : exportedBooks){
            String outputText = book.getTitle() + " | " + book.getIsbn()  + " | " + book.getAuthor();
            saveToFile(ALL_BOOKS_EXPORTED, outputText);
        }

        return exportedBooks;
    }

    @Override
    public Optional<Book> exportOneBooks(long id) throws IOException {
        Optional<Book> optionalBook = bookRepository.findById(id);
        Book oneBookToExport = optionalBook.get();
        String outputText = oneBookToExport.getTitle() + " | " + oneBookToExport.getIsbn()  + " | " + oneBookToExport.getAuthor();
        saveToFile(ONE_BOOK_EXPORTED, outputText);
        return optionalBook;
    }

    private void saveToFile(String fileName, String outputText) throws IOException {

        File file = new File(fileName);

        FileWriter fw = new FileWriter(file, true);

        PrintWriter pw = new PrintWriter(fw);

        pw.println(outputText);

        pw.close();

    }


}
