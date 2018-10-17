package com.example.lucas.todoapplication.integration.omdb;

import com.example.lucas.todoapplication.integration.omdb.response.OmdbResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OmdbApiService {

    @GET("?apiKey=a5f09f62")
    Call<OmdbResponse> findByTitle(@Query("t") String title);

    @GET("?apiKey=a5f09f62")
    Call<OmdbResponse> findById(@Query("i") String id);
}
