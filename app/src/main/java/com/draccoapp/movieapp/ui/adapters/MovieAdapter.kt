package com.draccoapp.movieapp.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.draccoapp.movieapp.api.model.response.movies.Result
import com.draccoapp.movieapp.api.model.type.MovieType
import com.draccoapp.movieapp.databinding.ItemMovieBinding
import com.draccoapp.movieapp.utils.Constants

class MovieAdapter(
    private val onClick: (Int, MovieType) -> Unit,
    private val type: MovieType
): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

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
        private val binding: ItemMovieBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Result){
            Log.e("TAG", "bind: ${Constants.POSTER_URL + movie.posterPath}" )
            binding.imageMovie.load(Constants.POSTER_URL + movie.posterPath)
            binding.textTitle.text = movie.title

            binding.root.setOnClickListener {
                onClick(bindingAdapterPosition, type)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMovieBinding.inflate(
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