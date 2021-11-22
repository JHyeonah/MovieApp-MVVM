package com.example.movieappmvvm.view.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappmvvm.data.Movie
import com.example.movieappmvvm.data.MovieRepository
import com.example.movieappmvvm.util.Debug
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {
    val movieList = MutableLiveData<List<Movie>>()

    init {
        getMovieList()
    }

    private fun getMovieList() {
        viewModelScope.launch {
            val response = movieRepository.getMovieList()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    Debug.log("get movie : ${response.body()}")
                    movieList.setValue(response.body()?.data?.movies)
                } else {
                    Debug.log("get movie error : ${response.message()}")
                }
            }
        }
//        job = CoroutineScope(Dispatchers.IO).launch {
//            val response = movieRepository.getMovieList()
//            withContext(Dispatchers.Main) {
//                if (response.isSuccessful) {
//                    movieList.postValue(response.body()?.data?.movies)
//                } else {
//                    Debug.log("get movie error : ${response.message()}")
//                }
//            }
//        }
    }

    fun searchMovies(query: String?) {
        query?.let {
            viewModelScope.launch {
                val response = movieRepository.searchMovieList(query)
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        Debug.log("search movie : ${response.body()}")
                        movieList.postValue(response.body()?.data?.movies)
                        Debug.log("movieList : ${movieList.value?.get(0)?.title}")
                    } else {
                        Debug.log("search movie error : ${response.message()}")
                    }
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}