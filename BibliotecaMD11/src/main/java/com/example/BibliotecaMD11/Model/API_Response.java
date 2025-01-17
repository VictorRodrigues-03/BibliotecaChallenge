package com.example.BibliotecaMD11.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record API_Response(@JsonAlias("results") List<BookData> resultado) {
}
