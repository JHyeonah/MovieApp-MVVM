package com.example.movieappmvvm.data

data class ListMovies(
    val data: Data
) {
    data class Data (
        val movies: ArrayList<Movie>?
    )
}