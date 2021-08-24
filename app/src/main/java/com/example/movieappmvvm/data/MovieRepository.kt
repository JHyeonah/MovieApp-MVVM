package com.example.movieappmvvm.data

import com.example.movieappmvvm.service.MovieService
import javax.inject.Inject


class MovieRepository @Inject constructor(private val service: MovieService) {

    fun getMovieList() = service.getMovieList()
}