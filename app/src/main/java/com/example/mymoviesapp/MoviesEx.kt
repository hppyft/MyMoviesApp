package com.example.mymoviesapp

data class Movie(val title: String, val id: Int, val posterPath: String)
data class Genre(var name: String)

interface MoviesApi {
    fun getAllMovies(): List<Movie>
}

interface GenreApi {
    fun getAllGenres(): List<Genre>
}

class TheMoviesDbApi : MoviesApi, GenreApi {
    override fun getAllMovies(): List<Movie> {
        return List(10) { Movie(title = "Vingadores $it", id = it, posterPath = "") }
    }

    override fun getAllGenres(): List<Genre> {
        //TODO aqui a gente busca os generos da api
        return listOf()
    }
}