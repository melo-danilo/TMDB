package com.draccoapp.movieapp.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.draccoapp.movieapp.api.model.response.movies.Result
import com.draccoapp.movieapp.ui.fragments.TopMovieFragment

class ViewPagerMovieAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle, private val movies: List<Result>): FragmentStateAdapter(fragmentManager, lifecycle) {


    override fun getItemCount(): Int {
        return movies.size
    }

    override fun createFragment(position: Int): Fragment {

        movies.forEach {
//            return TopMovieFragment(it)
        }

        return Fragment()
    }
}