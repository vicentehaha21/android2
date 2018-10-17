package com.example.lucas.todoapplication.integration;

import com.example.lucas.todoapplication.domain.ResponseData;

import java.util.List;

public interface ResponseCallback {
    void onSuccess(ResponseData data);

    void onSuccess(List<ResponseData> data);

    void onError(Throwable e);
}