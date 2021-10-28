package com.example.movieappmvvm.view.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappmvvm.comm.BaseViewModel
import com.example.movieappmvvm.data.Movie
import com.example.movieappmvvm.data.MovieRepository
import com.example.movieappmvvm.util.Debug
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {

    private fun searchMovies(query: String) {
        viewModelScope.launch {
            val response = movieRepository.searchMovieList(query)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    Debug.log("search movie : ${response.body()}")
                } else {
                    Debug.log("search movie error : ${response.message()}")
                }
            }
        }
    }
}