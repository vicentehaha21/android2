package com.example.lucas.todoapplication.integration.tmdb.response;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;

public class TmdbResultResponse {
    private Integer id;
    @SerializedName("vote_count")
    private Integer voteCount;
    @SerializedName("vote_average")
    private Double voteAverage;
    private Boolean video;
    private String title;
    private Double popularity;
    @SerializedName("poster_path")
    private String posterPath;
    private String overview;
    @SerializedName("release_date")
    private String releaseDate;

    public Integer getId() {
        return id;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public Boolean getVideo() {
        return video;
    }

    public String getTitle() {
        return title;
    }

    public Double getPopularity() {
        return popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
