package com.example.lucas.todoapplication.integration.tmdb.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Genre {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("name")
@Expose
private String name;
}