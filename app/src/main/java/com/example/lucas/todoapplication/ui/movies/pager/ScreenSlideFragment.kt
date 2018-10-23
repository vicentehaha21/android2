package com.example.lucas.todoapplication.ui.movies.pager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lucas.todoapplication.R
import com.example.lucas.todoapplication.ui.movies.toprated.TopRatedMoviesViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ScreenSlideFragment : Fragment() {
    val compositeDisposable = CompositeDisposable()
    val topRatedMoviesViewModel = TopRatedMoviesViewModel()
    lateinit var mView: View
    lateinit var mPager: ViewPager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = layoutInflater.inflate(R.layout.fragment_screen_slide, container, false)
        mPager = mView.findViewById(R.id.pager)
        findTopRatedMovies()
        return mView;
    }

    private fun findTopRatedMovies() {
        compositeDisposable.add(topRatedMoviesViewModel.topRatedMovies!!
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ items ->
                    mPager.adapter = ScreenSlidePagerAdapter(context!!, items.subList(0, 5).toCollection(arrayListOf()))
                }, {
                    Log.i("LogX", "Zangou")
                }, { Log.i("LogX", "Finalizou") }))
    }
}