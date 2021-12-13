package com.example.movieappmvvm.data

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson

class MovieConverters {
    @TypeConverter
    fun stringToList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()

    @TypeConverter
    fun listToJson(value: List<String>) = Gson().toJson(value)

    @TypeConverter
    fun stringToCastList(value: String) = Gson().fromJson(value, Array<Cast>::class.java).toList()

    @TypeConverter
    fun castListToJson(value: List<Cast>) = Gson().toJson(value)
}
