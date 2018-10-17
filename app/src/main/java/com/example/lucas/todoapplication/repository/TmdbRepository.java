package com.example.lucas.todoapplication.repository;

import com.example.lucas.todoapplication.integration.ResponseCallback;
import com.example.lucas.todoapplication.integration.tmdb.TmdbIntegrationService;
import com.example.lucas.todoapplication.integration.tmdb.response.TmdbMovieResponse;
import com.example.lucas.todoapplication.integration.tmdb.response.TmdbResponse;

public class TmdbRepository {

    public void findByTitle(String title, ResponseCallback<TmdbResponse> responseCallback) {
        TmdbIntegrationService.getInstance().findByTitle(title.trim()).enqueue(responseCallback);
    }

    public void findById(Integer id, ResponseCallback<TmdbMovieResponse> responseCallback) {
        TmdbIntegrationService.getInstance().findById(id).enqueue(responseCallback);
    }

}
