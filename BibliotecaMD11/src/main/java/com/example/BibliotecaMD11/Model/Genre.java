package com.example.BibliotecaMD11.Model;

public enum Genre {
    FICTION("Fiction"),
    DRAMA("Drama"),
    ROMANCE("Romance"),
    ADVENTURE("Adventure"),
    CRIME("Crime"),
    FANTASY("Fantasy"),
    MYSTERY("Mystery"),
    NOVEL("Novel");


    private String english;

    Genre(String englishG){
        this.english = englishG;
    }

    public static Genre getGenre(String genreE) {
        String[] parts = genreE.split("-- ");
        // Pega a última parte
        String lastPart = parts[1];
        for (Genre Genre : Genre.values()) {
            if (Genre.english.equals(lastPart)) {
                return Genre;
            }
        }
        throw new IllegalArgumentException();
    }

}
