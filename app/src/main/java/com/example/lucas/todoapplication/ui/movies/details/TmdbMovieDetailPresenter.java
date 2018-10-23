package com.example.lucas.todoapplication.ui.movies.details;

import com.example.lucas.todoapplication.domain.ErrorData;
import com.example.lucas.todoapplication.domain.TmdbData;
import com.example.lucas.todoapplication.repository.integration.ResponseCallback;
import com.example.lucas.todoapplication.repository.integration.tmdb.response.TmdbMovieResponse;
import com.example.lucas.todoapplication.repository.TmdbRepository;

public class TmdbMovieDetailPresenter implements MovieDetailsContract.Presenter {

    MovieDetailsContract.View view;

    public TmdbMovieDetailPresenter(MovieDetailsContract.View view) {
        this.view = view;
    }

    public void findByTitle(Integer id) {
        new TmdbRepository().findById(id, new ResponseCallback<TmdbMovieResponse>() {

            @Override
            public void onError(ErrorData data) {
                view.showErrorMessage(data.getMessage());
            }

            @Override
            public void onSuccess(TmdbMovieResponse data) {
                view.setMovie(TmdbData.from(data));
                view.hideLoading();
            }
        });
    }

    @Override
    public void onViewLoaded() {

    }
}
