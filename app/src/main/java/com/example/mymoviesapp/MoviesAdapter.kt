package com.example.mymoviesapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mymoviesapp.databinding.MovieItemBinding

class MoviesAdapter(val movieClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    class ViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)

    val dataSet: MutableList<Movie> = mutableListOf()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val binding = MovieItemBinding.inflate(inflater, viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataSet.get(position)
        viewHolder.binding.titulo = item.title
//        viewHolder.binding.posterIV.setImageDrawable()
        viewHolder.binding.itemBackground.setOnClickListener {
            movieClickListener(item.id)
        }
    }

    override fun getItemCount() = dataSet.size

    fun setItems(list: List<Movie>) {
        dataSet.clear()
        dataSet.addAll(list)
        notifyDataSetChanged()
    }
}