package com.example.lucas.todoapplication.contract;

import com.example.lucas.todoapplication.domain.TmdbData;

import java.util.ArrayList;

public interface MovieSearchContract {

    interface Presenter {
        public void onViewLoaded();
    }

    interface View {
        void setMoviesList(ArrayList<TmdbData> movies);
        void showErrorMessage(String errorMessage);
        void showLoading();
        void hideLoading();
    }
}
