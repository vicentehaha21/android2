package com.example.lucas.todoapplication.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.lucas.todoapplication.R;
import com.example.lucas.todoapplication.domain.OmdbData;
import com.example.lucas.todoapplication.domain.ResponseData;
import com.example.lucas.todoapplication.domain.TmdbData;
import com.example.lucas.todoapplication.integration.ResponseCallback;
import com.example.lucas.todoapplication.service.DownloadImageService;
import com.example.lucas.todoapplication.service.TmdbService;
import com.example.lucas.todoapplication.util.DialogUtils;

import java.util.List;

public class MovieDetailsActivity extends AppCompatActivity implements ResponseCallback {
    private OmdbData data;
    private Integer movieId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_panel);

        if (getIntent().getExtras() != null && getIntent().getExtras().containsKey("movieId")) {
            movieId = (Integer) getIntent().getSerializableExtra("movieId");
        }

        init();
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View view = super.onCreateView(parent, name, context, attrs);
        return view;
    }

    private void init() {
        if (movieId != null) {
            TmdbService tmdbService = new TmdbService(this);
            tmdbService.findById(movieId);
        } else {
            DialogUtils.errorDialog(this);
        }
    }

    @Override
    public void onSuccess(ResponseData data) {
        renderizeSuccessResponse((TmdbData) data);
    }

    @Override
    public void onSuccess(List data) {

    }

    @Override
    public void onError(Throwable e) {
        DialogUtils.errorDialog(this);
    }

    private void renderizeSuccessResponse(TmdbData data) {
        ((TextView) findViewById(R.id.movieTitle)).setText(data.getTitle());
        ((TextView) findViewById(R.id.moviePlot)).setText(data.getOverview());
        ((TextView) findViewById(R.id.movieYear)).setText(data.getReleaseDate());
        ((TextView) findViewById(R.id.movieGenre)).setText(data.getVoteAverage().toString());

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setMax(5);
        if(data.getPosterPath() != null)
            new DownloadImageService(findViewById(R.id.movieImage)).execute(data.getPosterPath());
    }
}
