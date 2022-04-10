package com.shubham.tmdbclient.data.repository.movie.datasource

import com.shubham.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>

}




































