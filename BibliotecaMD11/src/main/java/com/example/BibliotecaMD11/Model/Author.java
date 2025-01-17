package com.example.BibliotecaMD11.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tabela_Autores")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer birthYear;
    private Integer deathYear;
    @ManyToMany
    private List<Book> books = new ArrayList<>();

    public Author() {

    }

    public Author(AuthorsData authorsData) {
        this.birthYear = Integer.valueOf(authorsData.anoNascimento());
        this.name = authorsData.nome();
        this.deathYear = Integer.valueOf(authorsData.anoFalecimento());
    }

    private List<Book> getBooks() {
        return books;
    }

    private void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    @Override
    public String toString() {
        return "Autor " +
                "\n Nome = " + this.name +
                "\n Ano nascimento = " + this.birthYear +
                "\n Ano da Morte = " + this.deathYear;
    }
}
