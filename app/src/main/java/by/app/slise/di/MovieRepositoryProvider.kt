package by.app.slise.di

import com.android.academy.fundamentals.homework.data.MovieRepository

internal interface MovieRepositoryProvider {
    fun provideMovieRepository(): MovieRepository
}