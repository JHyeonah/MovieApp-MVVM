package com.example.movieappmvvm.adapters

import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context).load(imageUrl).into(view)
    }
}

@BindingAdapter("genreText")
fun bindGenreText(view: TextView, list: ArrayList<String>) {
    if (!list.isNullOrEmpty()) {
        var genre = ""
        for (i in list.iterator()) {
            genre += if (i == list[0]) {
                i
            } else {
                " / $i"
            }
        }
        view.text = genre
    }
}

@BindingAdapter("ratingText")
fun bindRatingText(view: TextView, rating: Float?) {
    if (rating != null) {
        view.text = String.format("%.1f", rating/2)
    }
}

@BindingAdapter("ratingStars")
fun bindRatingStars(view: RatingBar, rating: Float?) {
    if (rating != null) {
        view.rating = rating/2
    }
}

@BindingAdapter("textFromInt")
fun bindTextFromInt(view: TextView, i: Int) {
    view.text = i.toString()
}

@BindingAdapter("runtime")
fun bindRuntime(view: TextView, i: Int) {
    view.text = i.toString() + " Min"
}

