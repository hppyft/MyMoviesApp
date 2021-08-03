package com.example.mymoviesapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymoviesapp.model.model.MovieModel
import com.example.mymoviesapp.databinding.MovieItemBinding

class MoviesAdapter(val movieClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    class ViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)

    val dataSet: MutableList<MovieModel> = mutableListOf()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val binding = MovieItemBinding.inflate(inflater, viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataSet.get(position)
        viewHolder.binding.titulo = item.titulo
        Glide.with(viewHolder.binding.root)
            .load("https://image.tmdb.org/t/p/w500${item.caminhoDoPoster}")
            .into(viewHolder.binding.posterIV)
        viewHolder.binding.itemBackground.setOnClickListener {
            movieClickListener(item.id)
        }
    }

    override fun getItemCount() = dataSet.size

    fun setItems(list: List<MovieModel>) {
        dataSet.clear()
        dataSet.addAll(list)
        notifyDataSetChanged()
    }
}