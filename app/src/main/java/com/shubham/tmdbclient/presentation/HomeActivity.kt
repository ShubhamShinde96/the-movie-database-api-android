package com.shubham.tmdbclient.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.shubham.tmdbclient.R
import com.shubham.tmdbclient.databinding.ActivityHomeBinding
import com.shubham.tmdbclient.presentation.artist.ArtistActivity
import com.shubham.tmdbclient.presentation.movie.MovieActivity
import com.shubham.tmdbclient.presentation.tvshow.TvShowActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@HomeActivity, R.layout.activity_home)

        binding.movieButton.setOnClickListener {

            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)

        }

        binding.artistsButton.setOnClickListener {

            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)

        }

        binding.tvButton.setOnClickListener {

            val intent = Intent(this, TvShowActivity::class.java)
            startActivity(intent)

        }


        Glide.with(this@HomeActivity)
            .load("https://images.unsplash.com/photo-1598899134739-24c46f58b8c0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=856&q=80")
            .centerCrop()
            .into(binding.movieImg)

        Glide.with(this@HomeActivity)
            .load("https://images.pexels.com/photos/4009409/pexels-photo-4009409.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
            .centerCrop()
            .into(binding.tvShowImg)

        Glide.with(this@HomeActivity)
            .load("https://images.pexels.com/photos/7005068/pexels-photo-7005068.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
            .centerCrop()
            .into(binding.artistsImg)

    }



}
















