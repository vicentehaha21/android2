package com.example.lucas.todoapplication.domain;

import com.example.lucas.todoapplication.integration.tmdb.response.Genre;

import java.util.ArrayList;
import java.util.List;

public class GenreData extends ResponseData {
    private Integer id;
    private String name;

    public GenreData(Integer id, String name) {
        this.name = name;
    }

    public static List<GenreData> from(List<Genre> genres) {
        List<GenreData> data = new ArrayList<>();
        for (Genre genre : genres) {
            data.add(new GenreData(genre.getId(), genre.getName()));
        }

        return data;
    }

    @Override
    public String toString() {
        return name;
    }
}
