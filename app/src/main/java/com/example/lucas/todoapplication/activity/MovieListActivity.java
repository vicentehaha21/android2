package com.example.lucas.todoapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.lucas.todoapplication.R;
import com.example.lucas.todoapplication.adapter.MovieListAdapter;
import com.example.lucas.todoapplication.domain.ResponseData;
import com.example.lucas.todoapplication.domain.TmdbData;
import com.example.lucas.todoapplication.integration.ResponseCallback;
import com.example.lucas.todoapplication.service.TmdbService;
import com.example.lucas.todoapplication.util.DialogUtils;

import java.util.ArrayList;
import java.util.List;

public class MovieListActivity extends AppCompatActivity implements ResponseCallback {
    private ArrayList<TmdbData> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_list);
        if(getIntent().getExtras() != null && getIntent().getExtras().containsKey("movies")) {
            movies = (ArrayList<TmdbData>) getIntent().getSerializableExtra("movies");
        }
        init();
    }

    private void init() {
        ListView listView = findViewById(R.id.moviesList);
        listView.setAdapter(new MovieListAdapter(movies, this, new MovieListAdapter.MovieListListener() {
            @Override
            public void onClickItem(TmdbData data) {
                if(data != null && data.getId() != null) {
                    Intent intent = new Intent(MovieListActivity.this, MovieDetailsActivity.class);
                    intent.putExtra("movieId", data.getId());
                    startActivity(intent);
                } else {
                    DialogUtils.errorDialog(MovieListActivity.this);
                }
            }
        }));
    }

    @Override
    public void onSuccess(ResponseData data) {

    }

    @Override
    public void onSuccess(List data) {

    }

    @Override
    public void onError(Throwable e) {
        DialogUtils.errorDialog(this);
    }
}
