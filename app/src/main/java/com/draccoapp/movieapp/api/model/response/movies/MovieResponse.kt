package com.draccoapp.movieapp.api.model.response.movies


import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class MovieResponse(
    @SerializedName("dates")
    @Json(name = "dates")
    val dates: Dates?,
    @SerializedName("page")
    @Json(name = "page")
    val page: Int,
    @SerializedName("results")
    @Json(name = "results")
    val results: List<Result>,
    @SerializedName("total_pages")
    @Json(name = "total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    @Json(name = "total_results")
    val totalResults: Int
) : Serializable