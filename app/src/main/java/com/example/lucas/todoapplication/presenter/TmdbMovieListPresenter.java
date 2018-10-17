package com.example.lucas.todoapplication.presenter;

import com.example.lucas.todoapplication.contract.MovieListContract;
import com.example.lucas.todoapplication.domain.ErrorData;
import com.example.lucas.todoapplication.domain.TmdbData;
import com.example.lucas.todoapplication.integration.ResponseCallback;
import com.example.lucas.todoapplication.integration.tmdb.response.TmdbResponse;
import com.example.lucas.todoapplication.repository.TmdbRepository;

public class TmdbMovieListPresenter implements MovieListContract.Presenter {

    MovieListContract.View movieListView;

    public TmdbMovieListPresenter(MovieListContract.View movieListView) {
        this.movieListView = movieListView;
    }

    public void findByTitle(String title) {
        new TmdbRepository().findByTitle(title.trim(), new ResponseCallback<TmdbResponse>() {

            @Override
            public void onSuccess(TmdbResponse data) {
                movieListView.setMoviesList(TmdbData.from(data));
                movieListView.hideLoading();
            }

            @Override
            public void onError(ErrorData data) {
                movieListView.showErrorMessage(data.getMessage());
            }
        });
    }

    @Override
    public void onViewLoaded() {

    }
}
