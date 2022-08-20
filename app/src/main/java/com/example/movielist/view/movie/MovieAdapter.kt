package com.example.movielist.view.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movielist.BuildConfig
import com.example.movielist.data.movies.Movie
import com.example.movielist.databinding.MovieListBinding

class MovieAdapter(var listOfMovie: List<Movie>, val listener: movieListener?=null):
    RecyclerView.Adapter<MovieAdapter.movieViewHolder>() {

    interface movieListener{
        fun select(movie: Movie)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): movieViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
       val binding = MovieListBinding.inflate(layoutInflater, parent, false)
        return movieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: movieViewHolder, position: Int) {
        holder.bind(listOfMovie[position])

    }

    override fun getItemCount(): Int {
        return listOfMovie.size
    }


   inner class movieViewHolder(private val binding: MovieListBinding): RecyclerView.ViewHolder(binding.root){


        fun bind(movie: Movie){
            binding.tvTitle.text = movie.title

            Glide
                .with(binding.root.context)
                .load("${BuildConfig.IMAGE_URL}${movie.posterPath}")
                .into(binding.im01)

            binding.root.setOnClickListener {
                listener?.select(movie)
            }
        }

    }
}