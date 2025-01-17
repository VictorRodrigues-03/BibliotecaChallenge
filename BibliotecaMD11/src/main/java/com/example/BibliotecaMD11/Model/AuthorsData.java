package com.example.BibliotecaMD11.Model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record AuthorsData(@JsonAlias("name") String nome,
                          @JsonAlias("birth_year") String anoNascimento,
                          @JsonAlias("death_year") String anaFalecimento) {
}
