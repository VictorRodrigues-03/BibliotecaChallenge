package com.example.BibliotecaMD11.Model;

public enum Genre {
    FICTION("Fiction"),
    DRAMA("Drama"),
    ROMANCE("Romance"),
    ADVENTURE("Adventure"),
    CRIME("Crime"),
    FANTASY("Fantasy"),
    MYSTERY("Mystery"),
    NOVEL("Novel"),
    POETRY("Poetry"),
    HISTORY("History"),
    LITERATURE("Literature"),
    CULTURE("Culture"),
    SOCIETY("Society"),
    HUMOUR("Humour"),
    COMEDY("Comedy");


    private String english;

    Genre(String englishG){
        this.english = englishG;
    }

    public static Genre getGenre(String genreE) {
        String[] parts = genreE.split(": ");
        if (parts[1].contains("/")){
            parts[1] = parts[1].split("/")[0];
        }
        if (parts[1].contains("-")){
            parts[1] = parts[1].split(" - ")[0];
        }
        // Pega a última parte
        String lastPart = parts[1];
        for (Genre Genre : Genre.values()) {
            if (Genre.english.contains(lastPart)) {
                return Genre;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a String: " + genreE);

    }

}
