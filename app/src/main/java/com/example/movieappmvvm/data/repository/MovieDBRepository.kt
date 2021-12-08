package com.example.movieappmvvm.data.repository

import com.example.movieappmvvm.data.Movie
import com.example.movieappmvvm.data.MovieDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDBRepository @Inject constructor(private val movieDao: MovieDao) {
    suspend fun insertMovie(movie: Movie) {
        movieDao.insertMovie(movie)
    }

    suspend fun deleteMovie(movie: Movie) {
        movieDao.deleteMovie(movie)
    }
}