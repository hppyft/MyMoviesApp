package com.example.mymoviesapp

import android.content.Intent
import android.os.Bundle
import com.example.mymoviesapp.databinding.ActivityMovieListBinding

class MovieListActivity : CoreActivity() {

    private lateinit var binding: ActivityMovieListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()

        setupList()
    }

    private fun initLayout() {
        binding = ActivityMovieListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun setupList() {
        val adapter = MoviesAdapter { id ->
            toDetailsAct(id)
        }
        binding.moviesRV.adapter = adapter
        val api = TheMoviesDbApi()
        adapter.setItems(api.getAllMovies())
    }

}