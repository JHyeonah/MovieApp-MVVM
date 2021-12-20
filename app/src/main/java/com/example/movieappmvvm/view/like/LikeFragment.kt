package com.example.movieappmvvm.view.like

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieappmvvm.databinding.FragmentLikeBinding
import com.example.movieappmvvm.util.Debug
import com.example.movieappmvvm.view.list.MovieListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LikeFragment : Fragment() {
    private lateinit var binding: FragmentLikeBinding
    private val viewModel: LikeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLikeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        val adapter = MovieListAdapter()
        binding.movieRecycler.adapter = adapter
        binding.movieRecycler.layoutManager = LinearLayoutManager(context)

        subscribeUI(adapter)

        return binding.root
    }

    private fun subscribeUI(adapter: MovieListAdapter) {
        viewModel.movieList.observe(viewLifecycleOwner, Observer {
            Debug.log("likeList observed: $it")
            adapter.submitList(it.toMutableList())
        })
    }
}