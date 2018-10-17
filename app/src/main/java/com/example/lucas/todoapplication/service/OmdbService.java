package com.example.lucas.todoapplication.service;

import android.support.annotation.NonNull;

import com.example.lucas.todoapplication.domain.OmdbData;
import com.example.lucas.todoapplication.integration.ResponseCallback;
import com.example.lucas.todoapplication.integration.omdb.OmdbIntegrationService;
import com.example.lucas.todoapplication.integration.omdb.response.OmdbResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OmdbService {
    private ResponseCallback responseCallback;

    public OmdbService(ResponseCallback responseCallback) {
        this.responseCallback = responseCallback;
    }

    public void findByName(String title) {
        OmdbIntegrationService.getInstance().findByTitle(title).enqueue(new Callback<OmdbResponse>() {
            @Override
            public void onResponse(@NonNull Call<OmdbResponse> call, @NonNull Response<OmdbResponse> response) {
                responseCallback.onSuccess(OmdbData.from(response.body()));
            }

            @Override
            public void onFailure(@NonNull Call<OmdbResponse> call, @NonNull Throwable t) {
                responseCallback.onError(t);
            }

        });
    }

}
