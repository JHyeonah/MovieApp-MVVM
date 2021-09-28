package com.example.movieappmvvm.data

data class MovieDetail(
    val data: MovieData
) {
    data class MovieData (
        val movie: Movie
    )
}