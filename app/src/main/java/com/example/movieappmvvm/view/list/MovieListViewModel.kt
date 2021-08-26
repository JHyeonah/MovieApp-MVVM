package com.example.movieappmvvm.view.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieappmvvm.data.Movie
import com.example.movieappmvvm.data.MovieRepository
import com.example.movieappmvvm.util.Debug
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {
    val movieList = MutableLiveData<List<Movie>>()
    private var job: Job? = null

    fun getMovieList() {
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = movieRepository.getMovieList()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    movieList.postValue(response.body()?.data?.movies)
                } else {
                    Debug.log("get movie error : ${response.message()}")
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}