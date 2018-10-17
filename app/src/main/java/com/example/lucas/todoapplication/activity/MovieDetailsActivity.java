package com.example.lucas.todoapplication.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.lucas.todoapplication.R;
import com.example.lucas.todoapplication.contract.MovieDetailsContract;
import com.example.lucas.todoapplication.domain.TmdbData;
import com.example.lucas.todoapplication.presenter.TmdbMovieDetailPresenter;
import com.example.lucas.todoapplication.util.DialogUtils;
import com.example.lucas.todoapplication.util.ImageDownloader;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MovieDetailsActivity extends AppCompatActivity implements MovieDetailsContract.View {
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
            TmdbMovieDetailPresenter presenter = new TmdbMovieDetailPresenter(this);
            presenter.findByTitle(movieId);
        } else {
            DialogUtils.errorDialog(this);
        }
    }

    @Override
    public void setMovie(TmdbData movie) {
        renderizeSuccessResponse(movie);
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        DialogUtils.errorDialog(this);
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {

    }

    private void renderizeSuccessResponse(TmdbData data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String releaseDate = format.format(data.getReleaseDate());

        ((TextView) findViewById(R.id.movieTitle)).setText(data.getTitle());
        ((TextView) findViewById(R.id.moviePlot)).setText(data.getOverview());
        ((TextView) findViewById(R.id.movieYear)).setText(releaseDate);
        ((TextView) findViewById(R.id.movieGenre)).setText(data.getGenresAsString());
        ((RatingBar) findViewById(R.id.ratingBar)).setRating(data.getVoteAverage().floatValue() * 0.5F);

        ImageView imgView = findViewById(R.id.movieImage);
        imgView.setVisibility(View.GONE);
        if (data.hasPoster())
            new ImageDownloader(imgView).execute(data.getMediumPosterPath());
    }
}
