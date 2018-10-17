package com.example.lucas.todoapplication.domain;

import com.example.lucas.todoapplication.integration.omdb.response.OmdbResponse;

public class OmdbData extends ResponseData {

    private String title;
    private String plot;
    private String genre;
    private Integer year;
    private Double rating;
    private String poster;

    private OmdbData(String title, String plot, String genre, Integer year, Double rating, String poster) {
        this.title = title;
        this.plot = plot;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
        this.poster = poster;
    }

    public static OmdbData from(OmdbResponse response) {
        Double rating = Double.valueOf(response.getImdbRating());
        Integer year = Integer.valueOf(response.getYear());

        return new OmdbData(response.getTitle(), response.getPlot(), response.getGenre(), year, rating, response.getPoster());
    }

    public String getTitle() {
        return title;
    }

    public String getPlot() {
        return plot;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getYear() {
        return year;
    }

    public Double getRating() {
        return rating;
    }

    public String getPoster() {
        return poster;
    }
}
