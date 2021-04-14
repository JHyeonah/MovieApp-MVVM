package com.example.movieappmvvm.model

data class Movie (
    val title: String?,
    val summary: String?,
    val year: String?,
    val rating: Float?,
    val runtime: Float?,
    val genres: ArrayList<String>?,
    val description_full: String?,
    val background_image: String?,
    val medium_cover_image: String?
)