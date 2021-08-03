package com.example.mymoviesapp.view.activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.mymoviesapp.databinding.ActivityMovieListBinding
import com.example.mymoviesapp.view.adapter.MoviesAdapter
import com.example.mymoviesapp.viewmodel.MovieListViewModel

class MovieListActivity : CoreActivity() {
    private lateinit var binding: ActivityMovieListBinding
    private lateinit var adapter:MoviesAdapter
    private val viewModel: MovieListViewModel = ViewModelProvider(this).get(MovieListViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupList()
        addObservers()
        viewModel.getPopular()
    }


    private fun setupBinding(){
        binding = ActivityMovieListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun setupList(){
        adapter = MoviesAdapter { id ->
            viewModel.onMovieClicked(id)
        }
        binding.moviesRV.adapter = adapter
    }

    private fun addObservers() {
        viewModel.getLiveDataList().observe(this) {
            if (it != null) {
                binding.progress.visibility = View.GONE
                adapter.setItems(it)
            }
        }

        viewModel.getLiveDataId().observe(this){
            it?.let{
                toDetailsAct(it)
            }
        }
    }

}