package com.example.BibliotecaMD11.Repository;

import com.example.BibliotecaMD11.Model.Author;
import com.example.BibliotecaMD11.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {


    @Override
    Optional<Book> findById(Long aLong);

    @Query("SELECT a from Author a where a.birthYear < :ano AND a.deathYear > :ano")
    Optional<List<Author>> buscarAutoresVivos(Integer ano);

    Optional<Book> findByTitleContainingIgnoreCase(String s);

    @Query("select a FROM Author a WHERE a.name ILIKE :authorName")
    Optional<Author> procuraAutor(String authorName);

    @Query("select a FROM Author a WHERE a.name ILIKE %:authorName%")
    Optional<List<Author>> procuraAutorTrecho(String authorName);

    @Query(value = "SELECT * FROM tabela_livros", nativeQuery = true)
    List<Book> findAllBooks();

    @Query(value = "select * FROM tabela_autores", nativeQuery = true)
    List<Author> findAllAuthors();

    List<Book> findBookByLinguasContainingIgnoreCase(String lingua);

    List<Book> findByOrderByDownloadCountDesc();

}
