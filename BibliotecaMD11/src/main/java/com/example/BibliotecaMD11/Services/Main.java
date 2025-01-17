package com.example.BibliotecaMD11.Services;

import com.example.BibliotecaMD11.Model.Author;
import com.example.BibliotecaMD11.Model.Book;
import com.example.BibliotecaMD11.Model.BookData;
import com.example.BibliotecaMD11.Repository.BookRepository;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static BookRepository bookRepository;
    private static Scanner scanner = new Scanner(System.in);
    private DataConverter converter = new DataConverter();
    private SearchBooks searchService = new SearchBooks();

    public Main(BookRepository bookRepository) {
        Main.bookRepository = bookRepository;
    }

    public void opcao1(){
        BookData book = searchService.buscarLivro();
        List<Author> testAuthor = book.authors().stream()
                .map(a -> new Author(a))
                .collect(Collectors.toList());
        Book test = new Book(book);
        System.out.println(test);
        System.out.println(testAuthor);
        test.setAuthors(testAuthor);
        bookRepository.save(test);
    }


}
