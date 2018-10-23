package com.example.lucas.todoapplication.repository.integration;

import com.example.lucas.todoapplication.domain.ErrorData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class ResponseCallback<T> implements Callback<T>, KotlinResponseInterface<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful())
            onSuccess(response.body());
        else
            onError(new ErrorData("Resposta inesperada"));
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onError(new ErrorData("Erro de integração"));
    }
}
