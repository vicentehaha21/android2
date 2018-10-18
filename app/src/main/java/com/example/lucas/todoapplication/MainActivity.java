package com.example.lucas.todoapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.lucas.todoapplication.domain.TmdbData;
import com.example.lucas.todoapplication.viewmodel.TopRatedMoviesViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    TopRatedMoviesViewModel topRatedMoviesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        topRatedMoviesViewModel.getTopRatedMovies().subscribe(items -> {
            for (TmdbData item : items) {
                Log.i("LogX", item.getTitle());
            }
        });
    }
}
