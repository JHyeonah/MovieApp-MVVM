package com.example.movieappmvvm.data

import com.google.gson.annotations.SerializedName

data class Movie (
    val title: String?,
    val summary: String?,
    val year: String?,
    val rating: Float?,
    val runtime: Float?,
    val genres: ArrayList<String>?,
    @field:SerializedName("description_full") val description: String?,
    @field:SerializedName("background_image") val backgroundImage: String?,
    @field:SerializedName("medium_cover_image") val mediumImage: String?
)