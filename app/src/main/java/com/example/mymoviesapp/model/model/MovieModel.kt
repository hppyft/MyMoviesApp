package com.example.mymoviesapp.model.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies")
data class MovieModel(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "titulo")
    @SerializedName("title")
    val titulo: String,
    @ColumnInfo(name = "caminhoDoPoster")
    @SerializedName("poster_path")
    val caminhoDoPoster: String,
    @ColumnInfo(name = "caminhoDoPoster")
    @SerializedName("overview")
    val sinopse: String
)