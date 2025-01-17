package com.example.BibliotecaMD11.Repository;

import com.example.BibliotecaMD11.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {


}
