package com.example.lucas.todoapplication.integration.tmdb;

import com.example.lucas.todoapplication.domain.ResponseData;
import com.example.lucas.todoapplication.integration.tmdb.response.TmdbResponse;

import java.util.List;

public interface TmdbResponseCallback {
    void onSuccess(ResponseData data);

    void onSuccess(List<TmdbResponse> data);

    void onError(Throwable e);
}