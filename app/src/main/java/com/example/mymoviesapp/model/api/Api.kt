package com.example.mymoviesapp.model.api

import com.example.mymoviesapp.model.api.ApiConsts.PATH_MOVIE_ID
import com.example.mymoviesapp.model.api.ApiConsts.DEFAULT_QUERY
import com.example.mymoviesapp.model.model.MovieList
import com.example.mymoviesapp.model.model.MovieModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMoviesApi {

    @GET("popular?$DEFAULT_QUERY")
    fun listPopular(): Call<MovieList>

    @GET("{$PATH_MOVIE_ID}?$DEFAULT_QUERY")
    fun getMovieById(@Path(PATH_MOVIE_ID) id:Int): Call<MovieModel>
}

object ApiConsts {
    private const val API_KEY = "4973345a7972aabcf74fa87df6123627"
    const val PATH_MOVIE_ID = "id"
    const val DEFAULT_QUERY = "api_key=$API_KEY&language=en-US&page=1"
}
