package com.example.movieappmvvm.comm

import androidx.lifecycle.ViewModel
import com.example.movieappmvvm.service.MovieService
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

open class BaseViewModel : ViewModel(), KoinComponent {
    val api: MovieService by inject()

    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}