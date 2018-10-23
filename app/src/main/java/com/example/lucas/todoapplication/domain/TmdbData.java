package com.example.lucas.todoapplication.domain;

import android.support.annotation.Nullable;

import com.example.lucas.todoapplication.repository.integration.tmdb.response.TmdbMovieResponse;
import com.example.lucas.todoapplication.repository.integration.tmdb.response.TmdbResponse;
import com.example.lucas.todoapplication.repository.integration.tmdb.response.TmdbResultResponse;
import com.example.lucas.todoapplication.util.GlobalVars;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TmdbData extends ResponseData {

    private Integer id;
    private Integer voteCount;
    private Double voteAverage;
    private String title;
    private String posterPath;
    private String overview;
    private Date releaseDate;
    private List<GenreData> genres;

    private TmdbData(Integer id, String title, String posterPath, String overview, Date releaseDate) {
        this.id = id;
        this.title = title;
        this.posterPath = posterPath;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public TmdbData(Integer id, String title, String posterPath, String overview) {
        this.id = id;
        this.title = title;
        this.posterPath = posterPath;
        this.overview = overview;
    }

    public static ArrayList<TmdbData> from(@Nullable TmdbResponse response) {
        ArrayList<TmdbData> dataList = new ArrayList<>();
        for (TmdbResultResponse result : response.getResults()) {
            TmdbData data = new TmdbData(result.getId(), result.getTitle(), result.getPosterPath(), result.getOverview());
            dataList.add(data);
        }

        return dataList;
    }

    public static TmdbData from(TmdbMovieResponse response) {
        TmdbData data = new TmdbData(response.getId(), response.getTitle(), response.getPosterPath(), response.getOverview(), response.getReleaseDate());
        data.setVoteAverage(response.getVoteAverage());
        data.setVoteCount(response.getVoteCount());
        data.setGenres(GenreData.from(response.getGenres()));
        return data;
    }

    public String getTitle() {
        return title;
    }

    public Integer getId() {
        return id;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public List<GenreData> getGenres() {
        return genres;
    }

    public String getSmallPosterPath() {
        return String.format(GlobalVars.IMG_SERVER_PATH, GlobalVars.TMDB_IMG_SMALL, posterPath);
    }

    public String getMediumPosterPath() {
        return String.format(GlobalVars.IMG_SERVER_PATH, GlobalVars.TMDB_IMG_MEDIUM, posterPath);
    }

    public String getOriginalPosterPath() {
        return String.format(GlobalVars.IMG_SERVER_PATH, GlobalVars.TMDB_IMG_ORIGINAL, posterPath);
    }

    public Boolean hasPoster() {
        return this.posterPath != null;
    }

    public String getGenresAsString() {
        return genres.toString().replaceAll("\\[|\\]", "");
    }

    private void setGenres(List<GenreData> genres) {
        this.genres = genres;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    private void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    private void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    private void setTitle(String title) {
        this.title = title;
    }
}
