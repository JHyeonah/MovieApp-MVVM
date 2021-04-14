package com.example.movieappmvvm.service

import com.example.movieappmvvm.model.ListMovies
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface RetrofitService {
    @GET("list_movies.json")
    fun getMovieList(): Single<ListMovies>
}