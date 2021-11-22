package com.example.movieappmvvm.view.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappmvvm.data.Movie
import com.example.movieappmvvm.databinding.ItemMovieBinding
import com.example.movieappmvvm.view.main.MainViewPagerFragmentDirections

class MovieListAdapter : ListAdapter<Movie, RecyclerView.ViewHolder>(MovieDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MovieViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movie = getItem(position)
        (holder as MovieViewHolder).bind(movie)
    }

    override fun submitList(list: MutableList<Movie>?) {
        super.submitList((list?.let { ArrayList(it) }))
    }

    class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.itemLayout.setOnClickListener {
                binding.movie?.let { movie ->
                    navigateToDetail(movie, it)
                }
            }
        }

        fun bind(item: Movie) {
            binding.apply {
                movie = item
                executePendingBindings()
            }
        }

        private fun navigateToDetail(movie: Movie, view: View) {
            val direction = MainViewPagerFragmentDirections.actionMainToMovieDetail(movie.id)
            view.findNavController().navigate(direction)
        }
    }
}

private class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}