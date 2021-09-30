package com.example.movieappmvvm.view.detail

import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappmvvm.data.Cast
import com.example.movieappmvvm.databinding.ItemCastBinding

class CastAdapter : ListAdapter<Cast, RecyclerView.ViewHolder>(CastDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CastViewHolder(ItemCastBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val cast = getItem(position)
        (holder as CastViewHolder).bind(cast)
    }

    class CastViewHolder(private val binding: ItemCastBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Cast) {
            binding.apply {
                cast = item
                executePendingBindings()
            }

            binding.imgCast.background = ShapeDrawable(OvalShape())
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                binding.imgCast.clipToOutline = true
            }
        }
    }
}

private class CastDiffCallback : DiffUtil.ItemCallback<Cast>() {
    override fun areItemsTheSame(oldItem: Cast, newItem: Cast): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Cast, newItem: Cast): Boolean {
        return oldItem == newItem
    }
}