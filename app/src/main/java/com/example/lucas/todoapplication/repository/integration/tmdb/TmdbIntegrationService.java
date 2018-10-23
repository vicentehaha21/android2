package com.example.lucas.todoapplication.repository.integration.tmdb;

import com.example.lucas.todoapplication.util.GlobalVars;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TmdbIntegrationService {
    private static TmdbApiService INSTANCE;

    public static TmdbApiService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Retrofit.Builder()
                    .baseUrl(GlobalVars.TMDB_SERVER_PATH)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build().create(TmdbApiService.class);
        }
        return INSTANCE;
    }
}
