package com.example.lucas.todoapplication.integration.tmdb;

import com.example.lucas.todoapplication.util.GlobalVars;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TmdbIntegrationService {
    private static TmdbApiService INSTANCE;

    public static TmdbApiService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Retrofit.Builder()
                    .baseUrl(GlobalVars.TMDB_SERVER_PATH)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(TmdbApiService.class);
        }
        return INSTANCE;
    }
}
