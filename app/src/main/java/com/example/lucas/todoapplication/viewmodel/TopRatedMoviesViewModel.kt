package com.example.lucas.todoapplication.viewmodel

import com.example.lucas.todoapplication.domain.TmdbData
import com.example.lucas.todoapplication.repository.TmdbRepository
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class TopRatedMoviesViewModel @Inject constructor(private val tmdbRepository: TmdbRepository) {

    private val loadingStateObservable = PublishSubject.create<Boolean>()
    private val topRates: Single<ArrayList<TmdbData>> = Single.just(ArrayList())

    val topRatedMovies: Single<ArrayList<TmdbData>>
        get() {
            loadingStateObservable.onNext(true)
            tmdbRepository.getTopRates(topRates)
            return topRates
        }

    val loadingState: Observable<Boolean>
        get() = loadingStateObservable

}