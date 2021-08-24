package com.example.movieappmvvm.view.list

import androidx.lifecycle.ViewModel
import com.example.movieappmvvm.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {

    fun getMovieList() {

    }
}