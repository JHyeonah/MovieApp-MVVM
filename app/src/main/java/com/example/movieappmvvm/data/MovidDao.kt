package com.example.movieappmvvm.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies")
    fun getMovies(): Flow<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: Movie)

    @Delete
    suspend fun deleteMovie(movie: Movie)
}