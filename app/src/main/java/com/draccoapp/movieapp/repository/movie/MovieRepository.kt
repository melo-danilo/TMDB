package com.draccoapp.movieapp.repository.movie

import com.draccoapp.movieapp.api.model.request.MovieRequest
import com.draccoapp.movieapp.api.model.response.categories.CategoriesResponse
import com.draccoapp.movieapp.api.model.response.movies.MovieResponse
import com.draccoapp.movieapp.api.request.ApiRequest
import com.draccoapp.movieapp.api.service.movie.MovieService
import com.draccoapp.movieapp.utils.ResponseParser
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class MovieRepository(
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) {

    private val movieService = ApiRequest().getService(MovieService::class.java)

    suspend fun getCategories(language: String): Result<CategoriesResponse?> =
        withContext(dispatcher){
            try {
                val response = movieService.getCategories(
                    language = language
                )
                when {

                    response.isSuccessful -> {
                        Result.success(response.body())
                    }

                    else -> {
                        Result.failure(Throwable(ResponseParser.parseError(response)))
                    }
                }
            }catch (e: Exception){
                Result.failure(Throwable(e.message))
            }
        }

    suspend fun getMoviesPlaying(post: MovieRequest): Result<MovieResponse?> =
        withContext(dispatcher){
            try {
                val response = movieService.getMoviesPlaying(
                    airDateGte = post.airDateGte,
                    airDateLte = post.airDateLte,
                    certification = post.certification,
                    certificationCountry = post.certificationCountry,
                    debug = post.debug,
                    firstAirDateGte = post.firstAirDateGte,
                    firstAirDateLte = post.firstAirDateLte,
                    primaryReleaseDateGte = post.primaryReleaseDateGte,
                    primaryReleaseDateLte = post.primaryReleaseDateLte,
                    releaseDateGte = post.releaseDateGte,
                    releaseDateLte = post.releaseDateLte,
                    region = post.region,
                    showMe = post.showMe,
                    sortBy = post.sortBy,
                    voteAverageGte = post.voteAverageGte,
                    voteAverageLte  = post.voteAverageLte,
                    voteCountGte = post.voteCountGte,
                    watchRegion = post.watchRegion,
                    withGenres = post.withGenres,
                    withKeywords = post.withKeywords,
                    withNetworks = post.withNetworks,
                    withOriginCountry = post.withOriginCountry,
                    withOriginalLanguage = post.withOriginalLanguage,
                    withWatchMonetizationTypes = post.withWatchMonetizationTypes,
                    withWatchProviders = post.withWatchProviders,
                    withReleaseType = post.withReleaseType,
                    withRuntimeGte = post.withRuntimeGte,
                    withRuntimeLte = post.withRuntimeLte,
                    includeAdult = post.includeAdult,
                    includeVideo = post.includeVideo,
                    language = post.language,
                    page = post.page
                )
                when {

                    response.isSuccessful -> {
                        Result.success(response.body())
                    }

                    else -> {
                        Result.failure(Throwable(ResponseParser.parseError(response)))
                    }
                }
            }catch (e: Exception){
                Result.failure(Throwable(e.message))
            }
        }

    suspend fun getMoviesPopular(post: MovieRequest): Result<MovieResponse?> =
        withContext(dispatcher){
            try {
                val response = movieService.getMoviesPopular(
                    airDateGte = post.airDateGte,
                    airDateLte = post.airDateLte,
                    certification = post.certification,
                    certificationCountry = post.certificationCountry,
                    debug = post.debug,
                    firstAirDateGte = post.firstAirDateGte,
                    firstAirDateLte = post.firstAirDateLte,
                    primaryReleaseDateGte = post.primaryReleaseDateGte,
                    primaryReleaseDateLte = post.primaryReleaseDateLte,
                    releaseDateGte = post.releaseDateGte,
                    releaseDateLte = post.releaseDateLte,
                    region = post.region,
                    showMe = post.showMe,
                    sortBy = post.sortBy,
                    voteAverageGte = post.voteAverageGte,
                    voteAverageLte  = post.voteAverageLte,
                    voteCountGte = post.voteCountGte,
                    watchRegion = post.watchRegion,
                    withGenres = post.withGenres,
                    withKeywords = post.withKeywords,
                    withNetworks = post.withNetworks,
                    withOriginCountry = post.withOriginCountry,
                    withOriginalLanguage = post.withOriginalLanguage,
                    withWatchMonetizationTypes = post.withWatchMonetizationTypes,
                    withWatchProviders = post.withWatchProviders,
                    withReleaseType = post.withReleaseType,
                    withRuntimeGte = post.withRuntimeGte,
                    withRuntimeLte = post.withRuntimeLte,
                    includeAdult = post.includeAdult,
                    includeVideo = post.includeVideo,
                    language = post.language,
                    page = post.page
                )
                when {

                    response.isSuccessful -> {
                        Result.success(response.body())
                    }

                    else -> {
                        Result.failure(Throwable(ResponseParser.parseError(response)))
                    }
                }
            }catch (e: Exception){
                Result.failure(Throwable(e.message))
            }
        }

    suspend fun getMoviesTop(post: MovieRequest): Result<MovieResponse?> =
        withContext(dispatcher){
            try {
                val response = movieService.getMoviesTop(
                    airDateGte = post.airDateGte,
                    airDateLte = post.airDateLte,
                    certification = post.certification,
                    certificationCountry = post.certificationCountry,
                    debug = post.debug,
                    firstAirDateGte = post.firstAirDateGte,
                    firstAirDateLte = post.firstAirDateLte,
                    primaryReleaseDateGte = post.primaryReleaseDateGte,
                    primaryReleaseDateLte = post.primaryReleaseDateLte,
                    releaseDateGte = post.releaseDateGte,
                    releaseDateLte = post.releaseDateLte,
                    region = post.region,
                    showMe = post.showMe,
                    sortBy = post.sortBy,
                    voteAverageGte = post.voteAverageGte,
                    voteAverageLte  = post.voteAverageLte,
                    voteCountGte = post.voteCountGte,
                    watchRegion = post.watchRegion,
                    withGenres = post.withGenres,
                    withKeywords = post.withKeywords,
                    withNetworks = post.withNetworks,
                    withOriginCountry = post.withOriginCountry,
                    withOriginalLanguage = post.withOriginalLanguage,
                    withWatchMonetizationTypes = post.withWatchMonetizationTypes,
                    withWatchProviders = post.withWatchProviders,
                    withReleaseType = post.withReleaseType,
                    withRuntimeGte = post.withRuntimeGte,
                    withRuntimeLte = post.withRuntimeLte,
                    includeAdult = post.includeAdult,
                    includeVideo = post.includeVideo,
                    language = post.language,
                    page = post.page
                )
                when {

                    response.isSuccessful -> {
                        Result.success(response.body())
                    }

                    else -> {
                        Result.failure(Throwable(ResponseParser.parseError(response)))
                    }
                }
            }catch (e: Exception){
                Result.failure(Throwable(e.message))
            }
        }

}