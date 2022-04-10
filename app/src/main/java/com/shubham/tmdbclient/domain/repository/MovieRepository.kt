package com.shubham.tmdbclient.domain.repository

import com.shubham.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?

}