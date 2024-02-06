package com.draccoapp.movieapp.di

import com.draccoapp.movieapp.viewModel.movies.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module{
    viewModel{
        MovieViewModel()
    }
}
val repositoryModule = module{

}
val useCase = module {

}
val serviceModule = module{

}

val listModules = listOf(serviceModule, useCase, repositoryModule, viewModelModule)