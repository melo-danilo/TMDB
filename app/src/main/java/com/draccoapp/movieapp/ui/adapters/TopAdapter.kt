package com.draccoapp.movieapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.draccoapp.movieapp.api.model.response.movies.Result
import com.draccoapp.movieapp.databinding.ViewPagerItemMovieBinding
import com.draccoapp.movieapp.utils.Constants

class TopAdapter(
    private val onClick: (Result) -> Unit
): RecyclerView.Adapter<TopAdapter.ViewHolder>() {

    private var movieList: AsyncListDiffer<Result> = AsyncListDiffer(this, DiffCallBack)

    fun updateList(list: List<Result>){
        movieList.submitList(list)
    }

    object DiffCallBack : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(
            oldItem: Result,
            newItem: Result
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Result,
            newItem: Result
        ): Boolean {
            return oldItem == newItem
        }
    }

    inner class ViewHolder(
        private val binding: ViewPagerItemMovieBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Result){
            binding.imagePoster.load(Constants.POSTER_URL_VIEW + movie.posterPath)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ViewPagerItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return movieList.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieList.currentList[position])
    }
}