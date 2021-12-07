package com.example.movieappmvvm.data

import com.example.movieappmvvm.service.MovieService
import javax.inject.Inject


class MovieRepository @Inject constructor(private val service: MovieService, private val movieDao: MovieDao) {

    suspend fun getMovieList() = service.getMovieList()

    suspend fun getMovieDetail(id: Int) = service.getMovieDetail(id, withImages = true, withCast = true)

    suspend fun searchMovieList(query: String) = service.searchMovieList(query)

    suspend fun insertMovie(movie: Movie) {
        movieDao.insertMovie(movie)
    }
}