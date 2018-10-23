package com.example.lucas.todoapplication.ui.search;

import com.example.lucas.todoapplication.domain.ErrorData;
import com.example.lucas.todoapplication.domain.TmdbData;
import com.example.lucas.todoapplication.repository.integration.ResponseCallback;
import com.example.lucas.todoapplication.repository.integration.tmdb.response.TmdbResponse;
import com.example.lucas.todoapplication.repository.TmdbRepository;

public class TmdbMovieSearchPresenter implements MovieSearchContract.Presenter {

    MovieSearchContract.View view;

    public TmdbMovieSearchPresenter(MovieSearchContract.View view) {
        this.view = view;
    }

    public void findByTitle(String title) {
        new TmdbRepository().findByTitle(title.trim(), new ResponseCallback<TmdbResponse>() {

            @Override
            public void onSuccess(TmdbResponse data) {
                view.setMoviesList(TmdbData.from(data));
                view.hideLoading();
            }

            @Override
            public void onError(ErrorData data) {
                view.showErrorMessage(data.getMessage());
            }
        });
    }

    @Override
    public void onViewLoaded() {

    }
}
