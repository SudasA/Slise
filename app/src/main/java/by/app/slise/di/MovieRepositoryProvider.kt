package by.app.slise.di

import by.app.slise.data.MovieRepository


internal interface MovieRepositoryProvider {
    fun provideMovieRepository(): MovieRepository
}