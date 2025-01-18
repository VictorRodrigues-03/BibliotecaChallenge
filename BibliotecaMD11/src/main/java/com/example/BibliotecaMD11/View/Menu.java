package com.example.BibliotecaMD11.View;

import com.example.BibliotecaMD11.Repository.BookRepository;
import com.example.BibliotecaMD11.Services.Main;

import java.util.Scanner;

public class Menu {

    private final String menuS = """
            ======== Bem-Vindo da Biblioteca MD11 ========
            0 - Buscar Livro por Autor(API)
            1 - Buscar Livro(API)
            2 - Buscar Autor(Banco)
            3 - Buscar Livro(Banco)
            4 - Buscar Autores vivos em determinado ano
            5 - Listar livros
            6 - Listar autores
            7 - Listar livros por lingua
            8 - Top 10 livros mais baixados
            """;
    private final Scanner scanner = new Scanner(System.in);
    private final Main main;

    public Menu(BookRepository bookRepository) {
        this.main = new Main(bookRepository);
    }

    public void menu() {
        while (true){
            System.out.println(menuS);
            Integer op = scanner.nextInt();
            switch (op) {
                case 0:
                    main.opcao0();
                    break;
                case 1:
                    main.opcao1();
                    break;
                case 2:
                    main.opcao2();
                    break;
                case 3:
                    main.opcao3();
                    break;
                case 4:
                    main.opcao4();
                    break;
                case 5:
                    main.opcao5();
                    break;
                case 6:
                    main.opcao6();
                    break;
                case 7:
                    main.opcao7();
                    break;
                case 8:
                    main.opcao8();
                    break;
                default:
                    System.out.println("Terminado");
                    return;
            }
        }
    }

}
