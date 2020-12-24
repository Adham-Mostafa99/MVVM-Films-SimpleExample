package com.example.mvvmtraining.models;

public class FilmsData {
    private String filmName;
    private String filmUrl;

    public FilmsData(String filmName, String filmUrl) {
        this.filmName = filmName;
        this.filmUrl = filmUrl;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public void setFilmUrl(String filmUrl) {
        this.filmUrl = filmUrl;
    }

    public String getFilmName() {
        return filmName;
    }

    public String getFilmUrl() {
        return filmUrl;
    }
}
