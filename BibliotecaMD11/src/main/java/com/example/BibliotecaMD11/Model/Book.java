package com.example.BibliotecaMD11.Model;

import java.util.ArrayList;
import java.util.List;

public class Book {
    String title;
    List<Author> authors = new ArrayList<>();
    Genre genre;
    List<String> linguas;

    public Book(){

    }

    public Book(BookData bookData){
        this.title = bookData.title();
        this.genre = Genre.getGenre(bookData.genre().get(0));
        this.linguas = bookData.linguas();
    }

    private void setAuthors(List<Author> as){
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
        return "Title: " + title + ", Genre: " + genre + ", Linguas: " + linguas;
    }
}
