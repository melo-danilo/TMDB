package com.draccoapp.movieapp.dao

import androidx.room.Dao
import androidx.room.Query
import com.draccoapp.movieapp.api.model.response.movies.Movie
import com.draccoapp.movieapp.database.MovieDataBase

@Dao
abstract class MovieDao: BaseDao<Movie> {

    @Query("SELECT * FROM movie")
    abstract suspend fun getAll(): List<Movie>?

    @Query("SELECT * FROM movie where id=:id")
    abstract suspend fun getById(id: Int): Movie?

    @Query("DELETE FROM movie")
    abstract suspend fun deleteAll()

}