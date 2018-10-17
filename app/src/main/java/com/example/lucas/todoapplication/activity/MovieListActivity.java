package com.example.lucas.todoapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lucas.todoapplication.R;
import com.example.lucas.todoapplication.adapter.MovieListAdapter;
import com.example.lucas.todoapplication.domain.TmdbData;
import com.example.lucas.todoapplication.util.DialogUtils;

import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity {
    private ArrayList<TmdbData> movies;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_list);
        if (getIntent().getExtras() != null && getIntent().getExtras().containsKey("movies")) {
            movies = (ArrayList<TmdbData>) getIntent().getSerializableExtra("movies");
        }
        init();
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.moviesList);

        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(new MovieListAdapter(movies, this, v -> {
            int position = recyclerView.getChildAdapterPosition(v);
            onItemClick(movies.get(position));
        }));
    }

    private void onItemClick(TmdbData data) {
        if (data != null && data.getId() != null) {
            Intent intent = new Intent(MovieListActivity.this, MovieDetailsActivity.class);
            intent.putExtra("movieId", data.getId());
            startActivity(intent);
        } else {
            DialogUtils.errorDialog(MovieListActivity.this);
        }
    }
}
