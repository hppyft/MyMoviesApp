package com.example.mymoviesapp.view.activity

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.mymoviesapp.databinding.ActivityDetailsBinding
import com.example.mymoviesapp.model.repository.MovieRepository

class DetailsActivity : CoreActivity() {
    companion object {
        const val EXTRA_ID = "com.example.mymoviesapp.view.screens.DetailsActivity.EXTRA_ID"
    }

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val id = intent.getIntExtra(EXTRA_ID, -1)

        MovieRepository.getMovieById(id) {
            binding.detailsProgress.visibility = View.GONE
            binding.filme = it
            Glide.with(binding.root)
                .load("https://image.tmdb.org/t/p/w500${it.caminhoDoPoster}")
                .into(binding.posterId)
        }

    }
}