package com.example.movieappmvvm.data

import com.google.gson.annotations.SerializedName

data class Cast(
    val name: String?,
    @field:SerializedName("character_name") val characterName: String?,
    @field:SerializedName("url_small_name") val image: String?
)