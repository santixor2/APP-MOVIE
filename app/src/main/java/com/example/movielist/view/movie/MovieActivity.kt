package com.example.movielist.view.movie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movielist.data.detail.MovieDetail
import com.example.movielist.view.details.DetailActivity
import com.example.movielist.data.movies.Movie
import com.example.movielist.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieBinding
    private val viewModel: MovieViewModel by viewModels( factoryProducer = { MovieViewModelFactory() })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        val adapter = MovieAdapter(listOf(), object: MovieAdapter.movieListener {
            override fun select(movie: Movie) {
                val intent = Intent(this@MovieActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.id,movie.id)
               startActivity(intent)

            }

        })
        binding.rvMovie.layoutManager = LinearLayoutManager(this)
        binding.rvMovie.adapter = adapter

        viewModel.movies.observe(this){listOfMovie ->
            if (listOfMovie != null){
                adapter.listOfMovie = listOfMovie
                adapter.notifyDataSetChanged()


            }
        }

        viewModel.load()
    }
}