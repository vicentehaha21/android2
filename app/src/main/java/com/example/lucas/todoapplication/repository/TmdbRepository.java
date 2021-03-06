package com.example.lucas.todoapplication.repository;

import android.util.Log;

import com.example.lucas.todoapplication.repository.integration.ResponseCallback;
import com.example.lucas.todoapplication.repository.integration.tmdb.TmdbIntegrationService;
import com.example.lucas.todoapplication.repository.integration.tmdb.response.TmdbMovieResponse;
import com.example.lucas.todoapplication.repository.integration.tmdb.response.TmdbResponse;

import io.reactivex.Observable;

public class TmdbRepository {

    public void findByTitle(String title, ResponseCallback<TmdbResponse> responseCallback) {
        TmdbIntegrationService.getInstance().findByTitle(title.trim()).enqueue(responseCallback);
    }

    public void findById(Integer id, ResponseCallback<TmdbMovieResponse> responseCallback) {
        TmdbIntegrationService.getInstance().findById(id).enqueue(responseCallback);
    }

    public Observable<TmdbResponse> getTopRates() {
        Log.i("LogX", "Repository - Querying for top rated movies");
        return TmdbIntegrationService.getInstance().findTopRateds();
    }
}
