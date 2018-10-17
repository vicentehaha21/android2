package com.example.lucas.todoapplication.component;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.lucas.todoapplication.R;
import com.example.lucas.todoapplication.activity.MovieDetailsActivity;
import com.example.lucas.todoapplication.activity.MovieListActivity;
import com.example.lucas.todoapplication.domain.ResponseData;
import com.example.lucas.todoapplication.domain.TmdbData;
import com.example.lucas.todoapplication.integration.ResponseCallback;
import com.example.lucas.todoapplication.service.TmdbService;

import java.util.ArrayList;
import java.util.List;

public class MovieSearch extends RelativeLayout implements ResponseCallback {

    private Context mContext;

    public MovieSearch(Context context) {
        super(context);
        this.mContext = context;
        init(null);
    }

    public MovieSearch(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init(attrs);
    }

    public MovieSearch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        inflate(getContext(), R.layout.movie_search, this);
        ImageButton searchButton = findViewById(R.id.searchButton);
        EditText movieSearch = findViewById(R.id.movieSearch);
        searchButton.setOnClickListener(v -> search(movieSearch.getText().toString()));
    }

    private void search(String title) {
        TmdbService tmdbService = new TmdbService(this);
        tmdbService.findByName(title);
    }

    @Override
    public void onSuccess(ResponseData data) {
        // DO NOTHING
    }

    @Override
    public void onSuccess(List<ResponseData> movies) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("movies", new ArrayList<>(movies));
        Intent intent = new Intent(mContext, MovieListActivity.class);
        intent.putExtra("movies", new ArrayList<>(movies));
        mContext.startActivity(intent);
//        RelativeLayout.inflate(getContext(), R.layout.movie_list, this);
    }

    @Override
    public void onError(Throwable e) {

    }
}
