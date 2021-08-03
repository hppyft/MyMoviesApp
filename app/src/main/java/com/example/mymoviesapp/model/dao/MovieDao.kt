package com.example.mymoviesapp.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mymoviesapp.model.model.MovieModel

@Dao
interface MovieDao {
    @Query("""SELECT * FROM movies""")
    fun getAll():List<MovieModel>

    @Insert
    fun insertAll(vararg movie:MovieModel)

    @Delete
    fun delete(movie:MovieModel)
}