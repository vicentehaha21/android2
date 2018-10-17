package com.example.lucas.todoapplication.integration.omdb.response;

import com.google.gson.annotations.SerializedName;

class OmdbRateResponse {
    @SerializedName("Source")
    private String source;
    @SerializedName("Value")
    private String value;
}
