package com.example.movieappmvvm.data.repository

import com.example.movieappmvvm.data.Movie
import com.example.movieappmvvm.data.MovieDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDBRepository @Inject constructor(private val movieDao: MovieDao) {

    fun getMovies(): Flow<List<Movie>> {
        return movieDao.getMovies()
    }

    fun searchMovieById(id: Int): Flow<Boolean> {
        return movieDao.searchMovieById(id)
    }

    suspend fun insertMovie(movie: Movie) {
        movieDao.insertMovie(movie)
    }

    suspend fun deleteMovie(movie: Movie) {
        movieDao.deleteMovie(movie)
    }
}