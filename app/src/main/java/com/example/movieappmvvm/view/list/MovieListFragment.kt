package com.example.movieappmvvm.view.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.movieappmvvm.databinding.FragmentMovieListBinding
import com.example.movieappmvvm.util.Debug
import com.example.movieappmvvm.view.list.MovieListViewModel
import com.example.movieappmvvm.view.main.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListFragment : Fragment() {
    private lateinit var binding: FragmentMovieListBinding
    private val viewModel: MovieListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieListBinding.inflate(inflater, container, false)

        val adapter = MovieListAdapter()
        binding.movieRecycler.adapter = adapter

        subscribeUI(adapter)
        return binding.root
    }

    private fun subscribeUI(adapter: MovieListAdapter) {
        viewModel.movieList.observe (viewLifecycleOwner) {
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
        }
    }

}