package com.draccoapp.movieapp.api.model.response.movies


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@JsonClass(generateAdapter = true)
@Parcelize
data class Result(
    @SerializedName("adult")
    @Json(name = "adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    @Json(name = "backdrop_path")
    val backdropPath: String?,
    @SerializedName("genre_ids")
    @Json(name = "genre_ids")
    val genreIds: List<Int>,
    @SerializedName("id")
    @Json(name = "id")
    val id: Int,
    @SerializedName("original_language")
    @Json(name = "original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    @Json(name = "original_title")
    val originalTitle: String,
    @SerializedName("overview")
    @Json(name = "overview")
    val overview: String,
    @SerializedName("popularity")
    @Json(name = "popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    @Json(name = "poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    @Json(name = "release_date")
    val releaseDate: String,
    @SerializedName("title")
    @Json(name = "title")
    val title: String,
    @SerializedName("video")
    @Json(name = "video")
    val video: Boolean,
    @SerializedName("vote_average")
    @Json(name = "vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    @Json(name = "vote_count")
    val voteCount: Int
): Serializable, Parcelable