package com.example.lucas.todoapplication.integration.tmdb;

import com.example.lucas.todoapplication.integration.tmdb.response.TmdbMovieResponse;
import com.example.lucas.todoapplication.integration.tmdb.response.TmdbResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TmdbApiService {

    @GET("search/movie?api_key=bc10468769219d89343634c143280e17&language=pt-BR")
    Call<TmdbResponse> findByTitle(@Query("query") String title);

    @GET("movie/{id}?api_key=bc10468769219d89343634c143280e17&language=pt-BR")
    Call<TmdbMovieResponse> findById(@Path("id") Integer id);

    @GET("movie/top_rated?api_key=bc10468769219d89343634c143280e17&language=pt-BR")
    Call<TmdbResponse> findTopRateds();
}
