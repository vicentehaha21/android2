package com.example.lucas.todoapplication.repository.integration.tmdb.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TmdbResponse {
    private Integer page;
    @SerializedName("total_results")
    private Integer totalResults;
    @SerializedName("total_pages")
    private Integer totalPages;
    private List<TmdbResultResponse> results;

    public List<TmdbResultResponse> getResults() {
        return results;
    }

    public void setResults(List<TmdbResultResponse> results) {
        this.results = results;
    }
}