package com.example.movieappmvvm.view.like

import androidx.lifecycle.*
import com.example.movieappmvvm.data.Movie
import com.example.movieappmvvm.data.repository.MovieDBRepository
import com.example.movieappmvvm.util.Debug
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LikeViewModel @Inject constructor(private val movieDBRepository: MovieDBRepository) : ViewModel() {
    var movieList: LiveData<List<Movie>> = movieDBRepository.getMovies().asLiveData()

//    private fun getDBMovieList() {
//        viewModelScope.launch {
//            val response = movieDBRepository.getMovies()
//            withContext(Dispatchers.IO) {
//                movieList = response.asLiveData()
//            }
//        }
//    }
}