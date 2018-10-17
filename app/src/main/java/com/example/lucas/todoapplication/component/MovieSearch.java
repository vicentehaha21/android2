package com.example.lucas.todoapplication.component;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.lucas.todoapplication.R;
import com.example.lucas.todoapplication.activity.MovieListActivity;
import com.example.lucas.todoapplication.contract.MovieListContract;
import com.example.lucas.todoapplication.domain.TmdbData;
import com.example.lucas.todoapplication.presenter.TmdbMovieListPresenter;
import com.example.lucas.todoapplication.util.DialogUtils;

import java.util.ArrayList;
import java.util.List;

public class MovieSearch extends RelativeLayout implements MovieListContract.View {

    private Context mContext;

    public MovieSearch(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public MovieSearch(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    public MovieSearch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.movie_search, this);
        ImageButton searchButton = findViewById(R.id.searchButton);
        EditText movieSearch = findViewById(R.id.movieSearch);
        movieSearch.setOnKeyListener((v, k, e) -> {
            if (k == EditorInfo.IME_ACTION_DONE)
                search(movieSearch.getText().toString());
            return false;
        });
        searchButton.setOnClickListener(v -> search(movieSearch.getText().toString()));
    }

    private void search(String title) {
        if (!title.isEmpty()) {
            showLoading();
            TmdbMovieListPresenter presenter = new TmdbMovieListPresenter(this);
            presenter.findByTitle(title);
        }
    }

    @Override
    public void setMoviesList(List<TmdbData> movies) {
        Intent intent = new Intent(mContext, MovieListActivity.class);
        intent.putExtra("movies", new ArrayList<>(movies));
        mContext.startActivity(intent);
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        DialogUtils.errorDialog(mContext);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
