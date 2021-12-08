package com.example.movieappmvvm.data.repository

import com.example.movieappmvvm.service.MovieService
import javax.inject.Inject
import javax.inject.Singleton

class MovieRemoteRepository @Inject constructor(private val service: MovieService) {

    suspend fun getMovieList() = service.getMovieList()

    suspend fun getMovieDetail(id: Int) = service.getMovieDetail(id, withImages = true, withCast = true)

    suspend fun searchMovieList(query: String) = service.searchMovieList(query)

}