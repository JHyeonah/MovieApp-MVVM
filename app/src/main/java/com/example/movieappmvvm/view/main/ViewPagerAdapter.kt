package com.example.movieappmvvm.view.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.movieappmvvm.view.like.LikeFragment
import com.example.movieappmvvm.view.list.MovieListFragment

class ViewPagerAdapter(fragment: Fragment, query: String?) : FragmentStateAdapter(fragment) {

    private val tabFragmentCreators: Map<Int, () -> Fragment> = mapOf(
        0 to { MovieListFragment(query) },
        1 to { LikeFragment() }
    )

    override fun getItemCount(): Int = tabFragmentCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}