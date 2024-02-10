package com.draccoapp.movieapp.di

import androidx.room.Room
import com.draccoapp.movieapp.api.service.movie.MovieService
import com.draccoapp.movieapp.dao.MovieDao
import com.draccoapp.movieapp.database.MovieDataBase
import com.draccoapp.movieapp.repository.movie.MovieRepository
import com.draccoapp.movieapp.utils.Constants
import com.draccoapp.movieapp.utils.Env
import com.draccoapp.movieapp.viewModel.movies.MovieViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

private const val CONNECTION_TIMEOUT = 30 * 1000

val netWorkModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder().addInterceptor { chain ->
            val newRequest = chain.request().newBuilder()
                .header("accept", "application/json")
                .header(
                    "Authorization",
                    "Bearer ${
                        Env.token
                    }"
                )
                .build()
            chain.proceed(newRequest)
        }.connectTimeout(
            CONNECTION_TIMEOUT.toLong(),
            TimeUnit.MINUTES
        ).readTimeout(1, TimeUnit.MINUTES).build()
    }
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

}
val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            MovieDataBase::class.java,
            "movie_database"
        ).build()
    }
    single<MovieDao> {
        get<MovieDataBase>().movieDao
    }
}
val serviceModule = module{
    single {
        get<Retrofit>(Retrofit::class).create(MovieService::class.java)
    }
}
val repositoryModule = module{

    single<CoroutineDispatcher> { Dispatchers.Default }

    single {
        MovieRepository(get(), get())
    }
}
val viewModelModule = module{
    viewModel {
        MovieViewModel(get(), get())
    }
}


val listModules = listOf(netWorkModule, databaseModule, serviceModule, useCase, repositoryModule, viewModelModule)