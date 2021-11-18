package com.example.movieappmvvm.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.movieappmvvm.R
import com.example.movieappmvvm.databinding.FragmentMainViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator
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
        val searchbar = binding.searchBar

        viewPager.adapter = ViewPagerAdapter(this, null)

        TabLayoutMediator(tab, viewPager) { tabLayout, position ->
            tabLayout.setIcon(getTabIcon(position))
            tabLayout.text = getTabTitle(position)
        }.attach()

        searchbar.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
//                if (query != null && query.trim() != "") {
//                    tab.visibility = View.GONE
//                } else {
//                    tab.visibility = View.VISIBLE
//                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null && newText.trim() != "") {
                    tab.visibility = View.GONE
                } else {
                    tab.visibility = View.VISIBLE
                }
                return true
            }
        })
        return binding.root
    }



    private fun getTabIcon(position: Int): Int {
        return when (position) {
            0 -> R.drawable.movie_tab_selector
            1 -> R.drawable.like_tab_selector
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            0 -> getString(R.string.tab_movie_title)
            1 -> getString(R.string.tab_like_title)
            else -> null
        }
    }
}
