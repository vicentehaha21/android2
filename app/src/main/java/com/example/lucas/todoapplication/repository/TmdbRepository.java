package com.example.lucas.todoapplication.repository;

import com.example.lucas.todoapplication.domain.TmdbData;
import com.example.lucas.todoapplication.integration.ResponseCallback;
import com.example.lucas.todoapplication.integration.tmdb.TmdbIntegrationService;
import com.example.lucas.todoapplication.integration.tmdb.response.TmdbMovieResponse;
import com.example.lucas.todoapplication.integration.tmdb.response.TmdbResponse;
import com.example.lucas.todoapplication.integration.tmdb.response.TmdbResultResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.Component;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TmdbRepository {

    @Inject
    public TmdbRepository() {
    }

    public void findByTitle(String title, ResponseCallback<TmdbResponse> responseCallback) {
        TmdbIntegrationService.getInstance().findByTitle(title.trim()).enqueue(responseCallback);
    }

    public void findById(Integer id, ResponseCallback<TmdbMovieResponse> responseCallback) {
        TmdbIntegrationService.getInstance().findById(id).enqueue(responseCallback);
    }

    public void getTopRates(Single<ArrayList<TmdbData>> tmdbResponse) {
        TmdbIntegrationService.getInstance().findTopRateds().enqueue(new Callback<TmdbResponse>() {
            @Override
            public void onResponse(Call<TmdbResponse> call, Response<TmdbResponse> response) {
                if (response.isSuccessful()) {
                    tmdbResponse.ambWith(Single.amb(TmdbData.from(response.body())));
//                    tmdbResponse.concatWith(Single.amb()));
//                    tmdbResponse.;
                }
            }

            @Override
            public void onFailure(Call<TmdbResponse> call, Throwable t) {

            }
        });
    }

}
