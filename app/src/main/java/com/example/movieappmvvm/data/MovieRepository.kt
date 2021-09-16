package com.example.movieappmvvm.data

import com.example.movieappmvvm.service.MovieService
import javax.inject.Inject


class MovieRepository @Inject constructor(private val service: MovieService) {

    suspend fun getMovieList() = service.getMovieList()

    suspend fun getMovieDetail(id: Int) = service.getMovieDetail(id, withImages = true, withCast = true)
}