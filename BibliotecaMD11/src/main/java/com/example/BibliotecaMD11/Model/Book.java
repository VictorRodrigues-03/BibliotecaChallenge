package com.example.BibliotecaMD11.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tabela_Livros")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String title;
    @ManyToMany(mappedBy = "books",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Author> authors = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @ElementCollection
    @CollectionTable(name = "linguas", joinColumns = @JoinColumn(name = "book_id"))
    @Column(name = "lingua")
    private List<String> linguas;
    private Integer downloadCount;

    public Book(){

    }

    public Book(BookData bookData){
        this.title = bookData.title();
        this.genre = Genre.getGenre(bookData.genre().get(0));
        this.linguas = bookData.linguas();
        this.downloadCount = bookData.downloadCount();
    }

    public void setAuthors(List<Author> as){
        this.authors = as;
    }

    public String getTitle(){
        return title;
    }

    public Genre getGenre(){
        return genre;
    }

    @Override
    public String toString() {
        return "Title: " + title +
                ", Genre: " + genre +
                ", Linguas: " + linguas +
                ", Download Count: " + downloadCount;
    }


}
