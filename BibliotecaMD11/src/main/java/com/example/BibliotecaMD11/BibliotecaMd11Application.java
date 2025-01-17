package com.example.BibliotecaMD11;

import com.example.BibliotecaMD11.Repository.BookRepository;
import com.example.BibliotecaMD11.View.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaMd11Application implements CommandLineRunner {

	@Autowired
	BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {
		Menu menu = new Menu(bookRepository);
		menu.menu();
	}

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaMd11Application.class, args);
	}

}
