package com.stopkaaaa.androidacademyproject.ui.moviesdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.app.slise.moviedetails.MoviesDetailsViewModel


class MoviesDetailsViewModelFactory(
    private val movieId: Int
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (modelClass) {
            MoviesDetailsViewModel::class.java -> MoviesDetailsViewModel(this.movieId)
            else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
        } as T
    }
}