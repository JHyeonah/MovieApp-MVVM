package com.example.movieappmvvm.service

import com.example.movieappmvvm.data.ListMovies
import com.example.movieappmvvm.data.Movie
import com.example.movieappmvvm.data.MovieDetail
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("list_movies.json")
    suspend fun getMovieList(): Response<ListMovies>

    @GET("movie_details.json")
    suspend fun getMovieDetail(
        @Query("movie_id") id: Int,
        @Query("with_images") withImages: Boolean,
        @Query("with_cast") withCast: Boolean
    ): Response<MovieDetail>

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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(MovieService::class.java)
        }
    }
}