package com.example.lucas.todoapplication.domain;

import com.example.lucas.todoapplication.integration.tmdb.response.TmdbResponse;
import com.example.lucas.todoapplication.integration.tmdb.response.TmdbResultResponse;
import com.example.lucas.todoapplication.util.GlobalVars;

import java.util.ArrayList;
import java.util.List;

public class TmdbData extends ResponseData {

    private Integer id;
    private Integer voteCount;
    private Double voteAverage;
    private String title;
    private String posterPath;
    private String overview;
    private String releaseDate;

    public TmdbData(Integer id, String title, String posterPath, String overview, String releaseDate) {
        this.id = id;
        this.title = title;
        this.posterPath = GlobalVars.IMG_SERVER_PATH.concat(posterPath);
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public static List from(TmdbResponse response) {
        List<TmdbData> dataList = new ArrayList<>();
        for (TmdbResultResponse result : response.getResults()) {
            TmdbData data = new TmdbData(result.getId(), result.getTitle(), result.getPosterPath(), result.getOverview(), result.getReleaseDate());
            data.setVoteAverage(result.getVoteAverage());
            data.setVoteCount(result.getVoteCount());
            dataList.add(data);
        }

        return dataList;
    }

    public static ResponseData from(TmdbResultResponse result) {
        TmdbData data = new TmdbData(result.getId(), result.getTitle(), result.getPosterPath(), result.getOverview(), result.getReleaseDate());
        data.setVoteAverage(result.getVoteAverage());
        data.setVoteCount(result.getVoteCount());
        return data;
    }

    public String getTitle() {
        return title;
    }

    public Integer getId() {
        return id;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public Double getVoteAverage() {
        return voteAverage;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
