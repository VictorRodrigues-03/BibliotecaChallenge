package com.example.BibliotecaMD11.Services;

import com.example.BibliotecaMD11.Model.API_Response;
import com.example.BibliotecaMD11.Model.BookData;

import java.util.List;
import java.util.Scanner;

public class SearchBooks {

    private final String ENDERECO = "https://gutendex.com/books/?search=";
    private final Scanner scanner = new Scanner(System.in);
    private final ApiService apiService = new ApiService();
    private String url;
    private final DataConverter dataConverter = new DataConverter();


    public BookData buscarLivro(){
        System.out.println("Digite o nome do livro que deseja buscar:\n->");
        String livro = scanner.nextLine();
        url = ENDERECO + livro.replace(" ","+");
        API_Response response = dataConverter.obterDados(apiService.getData(url),API_Response.class);
        return response.resultado().get(0);
    }

    public List<BookData> buscarAutor(){
        System.out.println("Digite o nome do Autor que deseja buscar:\n->");
        String autor = scanner.nextLine();
        url = ENDERECO + autor.replace(" ","+");
        API_Response response = dataConverter.obterDados(apiService.getData(url),API_Response.class);
        return response.resultado();
    }


}
