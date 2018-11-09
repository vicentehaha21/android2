package com.example.lucas.todoapplication.ui.movies.toprated

import android.util.Log
import com.example.lucas.todoapplication.domain.TmdbData
import com.example.lucas.todoapplication.repository.TmdbRepository
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class TopRatedMoviesViewModel {
    val tmdbRepository: TmdbRepository = TmdbRepository()

    private val loadingStateObservable = PublishSubject.create<Boolean>()

    val topRatedMovies: Observable<java.util.ArrayList<TmdbData>>?
        get() {
            Log.i("LogX", "Querying for top rated movies")
            loadingStateObservable.onNext(true)
            return tmdbRepository.topRates
                    .map { r -> TmdbData.from(r) }
                    .doOnComplete { loadingStateObservable.onNext(false) }
        }

    val loadingState: Observable<Boolean>
        get() = loadingStateObservable
}