package com.example.movieappmvvm.view.detail

import androidx.lifecycle.*
import com.example.movieappmvvm.data.Movie
import com.example.movieappmvvm.data.repository.MovieDBRepository
import com.example.movieappmvvm.data.repository.MovieRemoteRepository
import com.example.movieappmvvm.util.Debug
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val movieRemoteRepository: MovieRemoteRepository,
    private val movieDBRepository: MovieDBRepository
): ViewModel() {

    private val movieId = savedStateHandle.get<Int>(MOVIE_ID)
    var isMovieExists: LiveData<Boolean> = movieDBRepository.searchMovieById(movieId ?: 0).asLiveData()
    val movie = MutableLiveData<Movie>()

    init {
        Debug.log("movieId : $movieId")
        getMovieDetail()
    }

    private fun getMovieDetail() {
        viewModelScope.launch {
            val response = movieRemoteRepository.getMovieDetail(movieId ?: 0)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    Debug.log("get movie detail : ${response.body()}")
                    movie.postValue(response.body()?.data?.movie)
                } else {
                    Debug.log("get movie error detail: ${response.message()}")
                }
            }
        }
    }

    fun insertMovie(movie: Movie?) {
        movie?.let {
            viewModelScope.launch {
                movieDBRepository.insertMovie(movie)
            }
        }
    }

    fun deleteMovie(movie: Movie?) {
        movie?.let {
            viewModelScope.launch {
                movieDBRepository.deleteMovie(movie)
            }
        }
    }

    companion object {
        private const val MOVIE_ID = "id"
    }
}