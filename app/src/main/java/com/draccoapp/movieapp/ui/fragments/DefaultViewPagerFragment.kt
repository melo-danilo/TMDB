package com.draccoapp.movieapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import coil.load
import com.draccoapp.movieapp.R
import com.draccoapp.movieapp.api.model.response.movies.Result
import com.draccoapp.movieapp.databinding.FragmentDefaultViewPagerBinding
import com.draccoapp.movieapp.utils.Constants
import com.draccoapp.movieapp.viewModel.movies.MovieViewModel


class DefaultViewPagerFragment : Fragment() {


    private var _binding: FragmentDefaultViewPagerBinding? = null
    private val binding get() = _binding!!
    private val viewModel by navGraphViewModels<MovieViewModel>(R.id.nav_main){ defaultViewModelProviderFactory }

    private val args: DefaultViewPagerFragmentArgs by navArgs()

    companion object {
        fun newInstance(items: Result?): DefaultViewPagerFragment {
            val fragment = DefaultViewPagerFragment()

            val args = Bundle().apply {
                putParcelable("result", items)
            }

            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDefaultViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
    }

    private fun setupUI() {
        val movie = args.result
        Log.e("TAG", "bind: ${Constants.POSTER_URL_VIEW + movie.posterPath}" )
        binding.imagePoster.load(Constants.POSTER_URL_VIEW + movie.posterPath)

        binding.imagePoster.setOnClickListener {
            viewModel.onMovieSelected(movie)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }


}