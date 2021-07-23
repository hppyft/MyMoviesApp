package com.example.mymoviesapp

import android.os.Bundle
import com.example.mymoviesapp.databinding.ActivityDetailsBinding

class DetailsActivity : CoreActivity() {
    companion object {
        const val EXTRA_ID = "com.example.mymoviesapp.DetailsActivity.EXTRA_ID"
    }

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val id = intent.getIntExtra(EXTRA_ID, -1)
        binding.filme = Movie("Vingadores $id", id, "")
    }
}