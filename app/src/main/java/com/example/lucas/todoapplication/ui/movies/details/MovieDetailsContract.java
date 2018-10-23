package com.example.lucas.todoapplication.ui.movies.details;

import com.example.lucas.todoapplication.domain.TmdbData;

public interface MovieDetailsContract {

    interface Presenter {
        public void onViewLoaded();
    }

    interface View {
        void setMovie(TmdbData movie);
        void showErrorMessage(String errorMessage);
        void showLoading();
        void hideLoading();
    }
}
