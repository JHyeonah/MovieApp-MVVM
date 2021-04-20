package com.example.movieappmvvm.view.main

import com.example.movieappmvvm.comm.BaseViewModel
import com.example.movieappmvvm.model.Movie
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.core.component.KoinApiExtension

class MainViewModel(): BaseViewModel() {
    fun callMovies(success: (list: ArrayList<Movie>) -> Unit, fail: () -> Unit) {
        api.getMovieList()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe({

        }, {

        })
    }
}