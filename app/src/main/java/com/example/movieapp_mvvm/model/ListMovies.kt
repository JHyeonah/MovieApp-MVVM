package com.example.movieapp_mvvm.model

data class ListMovies(
    val data: Data
) {
    data class Data (
        val movies: ArrayList<Movie>?
    )
}