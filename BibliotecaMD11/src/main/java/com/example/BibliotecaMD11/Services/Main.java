package com.example.BibliotecaMD11.Services;

import com.example.BibliotecaMD11.Model.BookData;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private DataConverter converter = new DataConverter();
    private SearchBooks searchService = new SearchBooks();

    public void opcao1(){
        BookData book = searchService.buscarLivro();

        System.out.println(book);
    }


}
