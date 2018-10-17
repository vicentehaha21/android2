package com.example.lucas.todoapplication.integration.omdb;

import com.example.lucas.todoapplication.util.GlobalVars;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OmdbIntegrationService {
    private static OmdbApiService INSTANCE;

    public static OmdbApiService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Retrofit.Builder()
                    .baseUrl(GlobalVars.OMDB_SERVER_PATH)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(OmdbApiService.class);
        }
        return INSTANCE;
    }
}
