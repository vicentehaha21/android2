package com.example.lucas.todoapplication.ui.toprated

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.lucas.todoapplication.R
import com.example.lucas.todoapplication.ui.loading.LoadingView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class TopRatedFragment : Fragment() {

    lateinit var mView: View
    val compositeDisposable = CompositeDisposable()
    lateinit var listView: ListView
    lateinit var topRatedMoviesViewModel: TopRatedMoviesViewModel
    lateinit var loadingView: LoadingView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        this.mView = inflater.inflate(R.layout.top_rateds_fragment, container, false)
        init()
        return mView
    }

    fun init() {
        listView = mView.findViewById(R.id.topRatedList)
        loadingView = mView.findViewById(R.id.loading)
        topRatedMoviesViewModel = TopRatedMoviesViewModel()
        watchLoadingState()
        findTopRatedMovies()
    }


    private fun findTopRatedMovies() {
        compositeDisposable.add(topRatedMoviesViewModel.topRatedMovies!!
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ items ->
                    listView.adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1,
                            items.subList(0, 5).map { item -> item.title })
                }, { error ->
                    logError(error)
                }, { Log.i("LogX", "Finalizou") }))
    }

    private fun watchLoadingState() {
        compositeDisposable.add(topRatedMoviesViewModel.loadingState
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { isLoading ->
                    if (isLoading) showLoading() else hideLoading()
                })
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

    private fun showLoading() {
        loadingView.show()
    }

    private fun hideLoading() {
        loadingView.hide()
    }

    private fun logError(error: Throwable) {
        Log.e("LogX", "Erro:")
        Log.e("LogX", error.message)
        Log.e("LogX", error.stackTrace.toString())
    }
}