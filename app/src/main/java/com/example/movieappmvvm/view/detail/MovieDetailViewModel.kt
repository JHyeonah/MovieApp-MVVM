package com.example.movieappmvvm.view.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.movieappmvvm.data.MovieRepository
import com.example.movieappmvvm.util.Debug
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val movieRepository: MovieRepository
): ViewModel() {

    private val movieId = savedStateHandle.get<Int>(MOVIE_ID)

    init {
        Debug.log("movieId : $movieId")
    }

    companion object {
        private const val MOVIE_ID = "id"
    }
}