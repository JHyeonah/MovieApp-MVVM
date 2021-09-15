package com.example.movieappmvvm.data

import com.google.gson.annotations.SerializedName

data class Movie (
    val id: Int,
    val title: String?,
    val summary: String?,
    val year: Int?,
    val rating: Float?,
    val runtime: Float?,
    val genres: ArrayList<String>?,
    @field:SerializedName("description_full") val description: String?,
    @field:SerializedName("background_image") val backgroundImage: String?,
    @field:SerializedName("medium_cover_image") val mediumImage: String?,
    @field:SerializedName("medium_screenshot_image1") val screenshotImage1: String?,
    @field:SerializedName("medium_screenshot_image2") val screenshotImage2: String?,
    @field:SerializedName("medium_screenshot_image3") val screenshotImage3: String?,
    val cast: ArrayList<Cast>?
)