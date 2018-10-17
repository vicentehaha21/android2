package com.example.lucas.todoapplication.contract;

import com.example.lucas.todoapplication.domain.TmdbData;

import java.util.List;

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
