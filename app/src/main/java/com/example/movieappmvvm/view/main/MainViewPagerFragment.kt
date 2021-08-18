package com.example.movieappmvvm.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.movieappmvvm.R
import com.example.movieappmvvm.databinding.FragmentMainViewPagerBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.IndexOutOfBoundsException
import java.text.FieldPosition

@AndroidEntryPoint
class MainViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainViewPagerBinding.inflate(inflater, container, false)
        val tab = binding.tabs
        val viewPager = binding.viewPager



        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun getTabIcon(position: Int): Int {
        return when (position) {
            0 -> R.drawable.movie_tab_selector
            1 -> R.drawable.like_tab_selector
            else -> throw IndexOutOfBoundsException()
        }
    }
}