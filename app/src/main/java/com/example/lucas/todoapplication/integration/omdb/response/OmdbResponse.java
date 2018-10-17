package com.example.lucas.todoapplication.integration.omdb.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OmdbResponse {
    @SerializedName("Title")
    private String title;

    @SerializedName("Year")
    private String year;

    @SerializedName("Rated")
    private String rated;

    @SerializedName("Released")
    private String released;

    @SerializedName("Runtime")
    private String runtime;

    @SerializedName("Genre")
    private String genre;

    @SerializedName("Director")
    private String director;

    @SerializedName("Writer")
    private String writer;

    @SerializedName("Actors")
    private String actors;

    @SerializedName("Language")
    private String language;

    @SerializedName("Country")
    private String country;

    @SerializedName("Awards")
    private String awards;

    @SerializedName("Poster")
    private String poster;

    @SerializedName("Metascore")
    private String metascore;

    private String imdbRating;

    private String imdbVotes;

    private String imdbID;

    @SerializedName("Type")
    private String type;

    @SerializedName("DVD")
    private String dvd;

    @SerializedName("BoxOffice")
    private String boxOffice;

    @SerializedName("Production")
    private String production;

    @SerializedName("Website")
    private String website;

    @SerializedName("Response")
    private String response;

    @SerializedName("Ratings")
    private List<OmdbRateResponse> ratings;

    @SerializedName("Plot")
    private String plot;

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public String getPlot() {
        return plot;
    }

    public String getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getImdbRating() {
        return imdbRating;
    }
}
