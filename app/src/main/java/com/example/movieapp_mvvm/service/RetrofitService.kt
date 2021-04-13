package com.example.movieapp_mvvm.service

import com.example.movieapp_mvvm.model.ListMovies
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface RetrofitService {
    @GET("list_movies.json")
    fun getMovieList(): Single<ListMovies>
}