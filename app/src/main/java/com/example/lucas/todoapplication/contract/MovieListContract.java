package com.example.lucas.todoapplication.contract;

import com.example.lucas.todoapplication.domain.TmdbData;

import java.util.List;

public interface MovieListContract {

    interface Presenter {
        public void onViewLoaded();
    }

    interface View {
        void setMoviesList(List<TmdbData> movies);
        void showErrorMessage(String errorMessage);
        void showLoading();
        void hideLoading();
    }
}
