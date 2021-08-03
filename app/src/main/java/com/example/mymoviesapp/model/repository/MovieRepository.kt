package com.example.mymoviesapp.model.repository

import android.content.Context
import androidx.room.Room
import com.example.mymoviesapp.model.api.TheMoviesApi
import com.example.mymoviesapp.model.database.AppDatabase
import com.example.mymoviesapp.model.model.MovieList
import com.example.mymoviesapp.model.model.MovieModel
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object MovieRepository {
    val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.themoviedb.org/3/movie/")
        .build()
    val moviesApi: TheMoviesApi = retrofit.create(TheMoviesApi::class.java)

    var database: AppDatabase? = null

    private fun getDb(context:Context){
        database =  Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-mymovies"
        ).build()
    }

    fun getDbMovies(context:Context, callback: (List<MovieModel>) -> Unit){
        if (database == null){
            getDb(context)
        }
//        database!!.movieDao(). //TODO
    }

    fun getPopular(callback: (List<MovieModel>) -> Unit) {
        CoroutineScope(GlobalScope.coroutineContext).launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                val call = moviesApi.listPopular()
                call.enqueue(object : Callback<MovieList> {
                    override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                        callback(response.body()?.results ?: mutableListOf())
                    }

                    override fun onFailure(call: Call<MovieList>, t: Throwable) {

                    }
                })
            }
        }
    }

    fun getMovieById(id: Int, callback: (MovieModel) -> Unit) {
        CoroutineScope(GlobalScope.coroutineContext).launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                val call = moviesApi.getMovieById(id)
                call.enqueue(object : Callback<MovieModel> {
                    override fun onResponse(
                        call: Call<MovieModel>,
                        response: Response<MovieModel>
                    ) {
                        response.body()?.let {
                            callback(it)
                        }
                    }

                    override fun onFailure(call: Call<MovieModel>, t: Throwable) {
                        println("CAIU NO onFailure")
                    }
                })
            }
        }
    }
}
