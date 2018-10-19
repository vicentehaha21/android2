package com.example.lucas.todoapplication.fragment

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.lucas.todoapplication.R
import com.example.lucas.todoapplication.viewmodel.TopRatedMoviesViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class TopRatedFragment : Fragment() {

    val compositeDisposable = CompositeDisposable()
    lateinit var progressDialog:ProgressDialog
    lateinit var listView: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        inflater.inflate(R.layout.top_rateds_fragment, container, false)
        init()
        return view
    }

    fun init() {
        teste()
    }

    private fun teste() {
        val topRatedMoviesViewModel = TopRatedMoviesViewModel()

        compositeDisposable.add(topRatedMoviesViewModel.loadingState.subscribe { isLoading ->
            if (isLoading!!) {
                //                Log.i("LogX", "isLoading");
                showLoading()
            } else {
                //                Log.i("LogX", "isNotLoading");
                hideLoading()
            }
        })

        compositeDisposable.add(topRatedMoviesViewModel.topRatedMovies!!
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ items ->
                    for (item in items) {
                        Log.i("LogX", item.title)
                    }
                }, { error ->
                    Log.e("LogX", "Erro:")
                    Log.e("LogX", error.message)
                    Log.e("LogX", error.stackTrace.toString())
                }, { Log.i("LogX", "Finalizou") }))
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

    private fun showLoading() {
        progressDialog = ProgressDialog.show(context, "Loading", "Please Wait")
        progressDialog.show()
    }

    private fun hideLoading() {
        progressDialog.dismiss()
    }
}