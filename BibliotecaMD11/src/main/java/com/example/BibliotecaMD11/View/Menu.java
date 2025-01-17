package com.example.BibliotecaMD11.View;

import com.example.BibliotecaMD11.Services.Main;

import java.util.Scanner;

public class Menu {

    private final String menuS = """
            ======== Bem-Vindo do Biblioteca MD11 ========
            0 - Buscar Livro por Autor(API)
            1 - Buscar Livro(API)
            2 - Buscar Autor(Banco)
            3 - Buscar Livro(Banco)
            4 - Buscar Autores vivos em determinado ano
            5 - Listar livros
            6 - Listar autores
            7 - Listar livros por lingua
            """;
    private final Scanner scanner = new Scanner(System.in);
    private final Main main = new Main();

    public void menu() {
        while (true){
            System.out.println(menuS);
            Integer op = scanner.nextInt();
            switch (op) {
                case 0:
                    return ;
                case 1:
                    main.opcao1();
                    break;
                default:
                    System.out.println("Em prod");
            }
        }
    }

}
