package com.example.movieappmvvm.service

import com.example.movieappmvvm.data.ListMovies
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MovieService {
    @GET("list_movies.json")
    fun getMovieList(): Single<ListMovies>

    companion object {
        private const val BASE_URL = "https://yts.mx/api/v2/"

        fun create(): MovieService {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovieService::class.java)
        }
    }
}