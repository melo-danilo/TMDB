package com.draccoapp.movieapp.viewModel.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.draccoapp.movieapp.api.model.event.Event
import com.draccoapp.movieapp.api.model.request.MovieRequest
import com.draccoapp.movieapp.api.model.response.categories.CategoriesResponse
import com.draccoapp.movieapp.api.model.response.movies.MovieResponse
import com.draccoapp.movieapp.api.model.response.movies.Result
import com.draccoapp.movieapp.api.model.type.DataState
import com.draccoapp.movieapp.api.model.type.MovieType
import com.draccoapp.movieapp.repository.movie.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel:  ViewModel() {

    private val movieRepository = MovieRepository()

    val error: LiveData<String>
        get() = _error

    private val _error = MutableLiveData<String>()

    val appState: LiveData<DataState>
        get() = _appState

    private val _appState = MutableLiveData<DataState>()

    val moviesPlaying: LiveData<MovieResponse>
        get() = _moviesPlaying

    private val _moviesPlaying = MutableLiveData<MovieResponse>()

    val moviesPopular: LiveData<MovieResponse>
        get() = _moviesPopular

    private val _moviesPopular = MutableLiveData<MovieResponse>()

    val moviesTop: LiveData<MovieResponse>
        get() = _moviesTop

    private val _moviesTop = MutableLiveData<MovieResponse>()


    val moviesDetail: LiveData<Result>
        get() = _moviesDetail

    private val _moviesDetail = MutableLiveData<Result>()

    val categories: LiveData<CategoriesResponse>
        get() = _categories

    private val _categories = MutableLiveData<CategoriesResponse>()

    val navigationToDetailsLiveData
        get() = _navigationToDetailsLiveData

    private val _navigationToDetailsLiveData = MutableLiveData<Event<Unit>>()

    init {
        _appState.postValue(DataState.Loading)
    }

    fun getCategories(language: String = "en"){

        viewModelScope.launch {
            val result = movieRepository.getCategories(language)

            result.fold(
                onSuccess = {
                    _categories.value = it
//                    _appState.value = DataState.Success
                },
                onFailure = {
                    it.message?.let { e ->
                        Log.e("Error", e)
                        _error.value = e
                    }
                    _appState.value = DataState.Error
                }
            )
        }
    }

    fun getMoviesPlaying(post: MovieRequest){
        _appState.postValue(DataState.Loading)

        viewModelScope.launch {
            val result = movieRepository.getMoviesPlaying(post)

            result.fold(
                onSuccess = {
                    _moviesPlaying.value = it
                    _appState.value = DataState.Success
                },
                onFailure = {
                    it.message?.let { e ->
                        Log.e("Error", e)
                        _error.value = e
                    }
                    _appState.value = DataState.Error
                }
            )
        }
    }

    fun getMoviesPopular(post: MovieRequest){
        _appState.postValue(DataState.Loading)

        viewModelScope.launch {
            val result = movieRepository.getMoviesPopular(post)

            result.fold(
                onSuccess = {
                    _moviesPopular.value = it
                    _appState.value = DataState.Success
                },
                onFailure = {
                    it.message?.let { e ->
                        Log.e("Error", e)
                        _error.value = e
                    }
                    _appState.value = DataState.Error
                }
            )
        }
    }

    fun getMoviesTop(post: MovieRequest){
        _appState.postValue(DataState.Loading)

        viewModelScope.launch {
            val result = movieRepository.getMoviesTop(post)

            result.fold(
                onSuccess = {
                    _moviesTop.value = it
                    _appState.value = DataState.Success
                },
                onFailure = {
                    it.message?.let { e ->
                        Log.e("Error", e)
                        _error.value = e
                    }
                    _appState.value = DataState.Error
                }
            )
        }
    }

    fun onMovieSelected(position: Int, movieType: MovieType){
        _moviesDetail.postValue(
            when(movieType){
                MovieType.PLAYING -> _moviesPlaying.value?.results?.get(position)
                MovieType.POPULAR -> _moviesPopular.value?.results?.get(position)
                MovieType.TOP -> _moviesTop.value?.results?.get(position)
            }
        )
        _navigationToDetailsLiveData.postValue(Event(Unit))

    }

    fun onMovieSelected(movie: Result) {
        _moviesDetail.postValue(movie)
        _navigationToDetailsLiveData.postValue(Event(Unit))
    }

}