package com.example.movielist.view.details

import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.movielist.BuildConfig
import com.example.movielist.R
import com.example.movielist.data.detail.MovieDetail
import com.example.movielist.databinding.ActivityDetailBinding
import com.example.movielist.view.movie.MovieViewModel
import com.example.movielist.view.movie.MovieViewModelFactory

class DetailActivity: AppCompatActivity() {
    companion object{
        const val id = "DetailActivity:id"
    }
    private lateinit var binding: ActivityDetailBinding
    private val viewModel: DetailViewModel by viewModels( factoryProducer = { DetailViewModelFactory() })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        val id = intent.getLongExtra(id,0)
            viewModel.detail.observe(this){
                if(it != null){
                    binding.tvTitle2.text = it.title
                    binding.tvIdioma.text = it.language
                    binding.tvOverview.text = it.overview
                    binding.tvPopu.text = it.popularity
                    Glide
                        .with(binding.root.context)
                        .load("${BuildConfig.IMAGE_URL}${it.backdropPath}")
                        .into(binding.iv01)
                }
            }
        viewModel.load(id)

    }
}