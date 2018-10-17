package com.example.lucas.todoapplication.service;

import android.support.annotation.NonNull;

import com.example.lucas.todoapplication.domain.OmdbData;
import com.example.lucas.todoapplication.domain.TmdbData;
import com.example.lucas.todoapplication.integration.ResponseCallback;
import com.example.lucas.todoapplication.integration.omdb.OmdbIntegrationService;
import com.example.lucas.todoapplication.integration.omdb.response.OmdbResponse;
import com.example.lucas.todoapplication.integration.tmdb.TmdbIntegrationService;
import com.example.lucas.todoapplication.integration.tmdb.response.TmdbResponse;
import com.example.lucas.todoapplication.integration.tmdb.response.TmdbResultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TmdbService {
    private ResponseCallback responseCallback;

    public TmdbService(ResponseCallback responseCallback) {
        this.responseCallback = responseCallback;
    }

    public void findByName(String title) {
        TmdbIntegrationService.getInstance().findByTitle(title.trim()).enqueue(new Callback<TmdbResponse>() {
            @Override
            public void onResponse(@NonNull Call<TmdbResponse> call, @NonNull Response<TmdbResponse> response) {
                responseCallback.onSuccess(TmdbData.from(response.body()));
            }

            @Override
            public void onFailure(@NonNull Call<TmdbResponse> call, @NonNull Throwable t) {
                responseCallback.onError(t);
            }

        });
    }

    public void findById(Integer id) {
        TmdbIntegrationService.getInstance().findById(id).enqueue(new Callback<TmdbResultResponse>() {
            @Override
            public void onResponse(@NonNull Call<TmdbResultResponse> call, @NonNull Response<TmdbResultResponse> response) {
                responseCallback.onSuccess(TmdbData.from(response.body()));
            }

            @Override
            public void onFailure(@NonNull Call<TmdbResultResponse> call, @NonNull Throwable t) {
                responseCallback.onError(t);
            }

        });
    }

}
