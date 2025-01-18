package com.example.BibliotecaMD11.Services;

import com.example.BibliotecaMD11.Model.Author;
import com.example.BibliotecaMD11.Model.AuthorsData;
import com.example.BibliotecaMD11.Model.Book;
import com.example.BibliotecaMD11.Model.BookData;
import com.example.BibliotecaMD11.Repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static BookRepository bookRepository;
    private static Scanner scanner = new Scanner(System.in);
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


    public void opcao0(){
        List<BookData> books = searchService.buscarAutor();
        List<Book> bookList = books.stream()
                .map(b -> new Book(b,buscaAutoresNovos(b.authors())))
                .collect(Collectors.toList());
        for (int i = 0; i < bookList.size(); i++) {
            Book b = bookList.get(i);
            Optional<Book> p = bookRepository.findByTitleContainingIgnoreCase(b.getTitle());
            if (!(p.isPresent())){
                bookRepository.save(b);
            }
        }
        bookList.forEach(System.out::println);
    }

    public void opcao2(){
        System.out.println("Digite o nome do Autor que deseja buscar:");
        String nome = scanner.nextLine();
        Optional<List<Author>> listE = bookRepository.procuraAutorTrecho(nome);
        if (listE.isPresent()){
            listE.get().forEach(System.out::println);
        }else {
            System.out.println("Não encontradoo");
        }

    }

    public List<Author> buscaAutoresNovos(List<AuthorsData> listA){
        List<Author> authors = new ArrayList<>();
        for (AuthorsData a : listA) {
            Optional<Author> searchedA = bookRepository.procuraAutor(a.nome());
            if (!searchedA.isPresent()) {
                Author newAuthor = new Author(a);
                authors.add(newAuthor);
            }
        }
        return authors;
    }

    public void opcao3() {
        System.out.println("Digite o titulo do livro que deseja buscar: ");
        String titulo = scanner.nextLine();
        Optional <Book> livroB = bookRepository.findByTitleContainingIgnoreCase(titulo);
        if (livroB.isPresent()){
            System.out.println(livroB.get());
        }else {
            System.out.println("Livro não encontrado");
        }

    }

    public void opcao4() {
        System.out.println("Digite o ano: ");
        Integer ano = scanner.nextInt();
        Optional<List<Author>> authorsB = bookRepository.buscarAutoresVivos(ano);
        if (authorsB.isPresent()){
            authorsB.get().forEach(System.out::println);
        }else {
            System.out.println("Nenhum autor vivo");
        }
    }

    public void opcao5() {
        List<Book> allBooks = bookRepository.findAllBooks();
        allBooks.forEach(System.out::println);
    }

    public void opcao6() {
        List<Author> allAuthorss = bookRepository.findAllAuthors();
        allAuthorss.forEach(System.out::println);
    }

    public void opcao7() {
        System.out.println("Escolha uma lingua para buscar(pt,fr,en): ");
        String lingua = scanner.nextLine();
        List<Book> livrosE = bookRepository.findBookByLinguasContainingIgnoreCase(lingua);
        livrosE.forEach(System.out::println);
    }

    public void opcao8() {
        bookRepository.findByOrderByDownloadCountDesc().stream()
                .limit(10)
                .forEach(System.out::println);
    }
}
