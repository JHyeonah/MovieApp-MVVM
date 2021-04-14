package com.example.movieappmvvm.model

data class ListMovies(
    val data: Data
) {
    data class Data (
        val movies: ArrayList<Movie>?
    )
}