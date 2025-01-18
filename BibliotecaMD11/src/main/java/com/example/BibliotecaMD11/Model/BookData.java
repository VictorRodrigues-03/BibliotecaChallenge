package com.example.BibliotecaMD11.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(@JsonAlias("title") String title,
                       @JsonAlias("authors") List<AuthorsData> authors,
                       @JsonAlias("bookshelves") List<String> genre,
                       @JsonAlias("download_count") Integer downloadCount,
                       @JsonAlias("languages") List<String> linguas) {
}
