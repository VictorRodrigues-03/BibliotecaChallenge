package com.example.BibliotecaMD11.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Entity
@Table(name = "tabela_Autores")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    private Integer birthYear;
    private Integer deathYear;
    @ManyToMany(mappedBy = "authors")
    private List<Book> books = new ArrayList<>();

    public Author() {

    }

    public Author(AuthorsData authorsData) {
        if (authorsData.anoNascimento() == null) {
            this.birthYear = 0;
            this.deathYear = 0;
        }else {
            this.birthYear = Integer.valueOf(authorsData.anoNascimento());
            this.deathYear = Integer.valueOf(authorsData.anoFalecimento());
        }
        this.name = authorsData.nome();
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
