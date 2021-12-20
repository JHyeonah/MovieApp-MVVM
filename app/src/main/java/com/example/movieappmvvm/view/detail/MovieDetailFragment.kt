package com.example.movieappmvvm.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import com.example.movieappmvvm.R
import com.example.movieappmvvm.databinding.FragmentMovieDetailBinding
import com.example.movieappmvvm.util.Debug
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {
    private lateinit var binding: FragmentMovieDetailBinding
    private val detailViewModel: MovieDetailViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false).apply {
            viewModel = detailViewModel
            lifecycleOwner = viewLifecycleOwner

            var isToolbarShown = false

            detailScrollview.setOnScrollChangeListener(
                NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, _ ->
                    // User scrolled past image to height of toolbar and the title text is
                    // underneath the toolbar, so the toolbar should be shown.'
                    val shouldShowToolbar = scrollY > toolbar.height

                    if (isToolbarShown != shouldShowToolbar) {
                        isToolbarShown = shouldShowToolbar

                        // Use shadow animator to add elevation if toolbar is shown
                        appBar.isActivated = shouldShowToolbar
                        toolbarLayout.isTitleEnabled = shouldShowToolbar
                        toolbarLayout.setExpandedTitleColor(ContextCompat.getColor(activity?.applicationContext!!, R.color.white))
                        toolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(activity?.applicationContext!!, R.color.white))
                    }
                }
            )

            toolbar.setNavigationOnClickListener { view ->
                view.findNavController().navigateUp()
            }
        }

        val adapter = CastAdapter()
        binding.actorRecycler.adapter = adapter

        subscribeUi(adapter)

        return binding.root
    }

    private fun subscribeUi(adapter: CastAdapter) {
        detailViewModel.movie.observe(viewLifecycleOwner) {
            binding.movie = it

            if (!it.cast.isNullOrEmpty()) {
                adapter.submitList(it.cast)
            } else {
                binding.actorLayout.visibility = View.GONE
            }

            val imgList = makeList(it.screenshotImage1, it.screenshotImage2, it.screenshotImage3)
            binding.imageViewPager.adapter = ImageViewPagerAdapter(requireContext(), imgList)
            binding.imageIndicator.setViewPager(binding.imageViewPager)
        }

        detailViewModel.isMovieExists.observe(viewLifecycleOwner) {
            val isExists = it
            with(binding) {
                if (isExists) {
                    fab.setImageResource(R.drawable.icon_heart_selected)
                } else {
                    fab.setImageResource(R.drawable.icon_heart_normal)
                }

                fab.setOnClickListener {
                    if (!isExists) {
                        fab.setImageResource(R.drawable.icon_heart_selected)
                        detailViewModel.insertMovie(binding.movie)
                    } else {
                        fab.setImageResource(R.drawable.icon_heart_normal)
                        detailViewModel.deleteMovie(binding.movie)
                    }
                }
            }
        }
    }

    private fun makeList(img1: String?, img2: String?, img3: String?): ArrayList<String> {
        val list = arrayListOf<String>()

        if (img1 != null) {
            list.add(img1)
        }

        if (img2 != null) {
            list.add(img2)
        }

        if (img3 != null) {
            list.add(img3)
        }

        return list
    }
}