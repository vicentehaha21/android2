package com.example.lucas.todoapplication.repository.integration.tmdb.response;

import com.google.gson.annotations.SerializedName;

public class TmdbResultResponse {
    private Integer id;
    private String title;
    @SerializedName("poster_path")
    private String posterPath;
    private String overview;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOverview() {
        return overview;
    }
}
