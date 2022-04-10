package com.shubham.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.shubham.tmdbclient.domain.use_cases.GetMoviesUseCase
import com.shubham.tmdbclient.domain.use_cases.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData {

        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovieList() = liveData {

        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }


}