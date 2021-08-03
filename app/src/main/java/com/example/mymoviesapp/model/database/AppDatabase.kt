package com.example.mymoviesapp.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mymoviesapp.model.dao.MovieDao
import com.example.mymoviesapp.model.model.MovieModel

@Database(entities = [MovieModel::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun movieDao(): MovieDao
}