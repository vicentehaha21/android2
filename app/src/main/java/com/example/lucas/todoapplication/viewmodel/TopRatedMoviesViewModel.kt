package com.example.lucas.todoapplication.viewmodel

import com.example.lucas.todoapplication.domain.TmdbData
import com.example.lucas.todoapplication.repository.TmdbRepository
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject

class TopRatedMoviesViewModel {

    val tmdbRepository: TmdbRepository = TmdbRepository()

    private val loadingStateObservable = PublishSubject.create<Boolean>()
    private val topRates: Single<ArrayList<TmdbData>> = Single.just(ArrayList())

    val topRatedMovies: Observable<java.util.ArrayList<TmdbData>>?
        get() {
            loadingStateObservable.onNext(true)
            return tmdbRepository.topRates
                    .map { r -> TmdbData.from(r) }
                    .doOnComplete { loadingStateObservable.onNext(false) }
        }

    val loadingState: Observable<Boolean>
        get() = loadingStateObservable

}