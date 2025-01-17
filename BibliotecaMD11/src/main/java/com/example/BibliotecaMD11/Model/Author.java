package com.example.BibliotecaMD11.Model;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private Integer birthYear;
    private Integer deathYear;
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
