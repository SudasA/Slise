package by.app.slise.MovieDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.app.slise.repositories.MoviesRepository
import by.app.slise.viewmodel.MoviesViewModel
import by.app.slise.viewmodel.Navigator

class MovieDetailsViewModel(val moviesRepository: MoviesRepository, val navigator: Navigator): ViewModel() {










    @Suppress("UNCHECKED_CAST")
    class Factory(private val repo: MoviesRepository, private val navigator: Navigator) :
            ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MoviesViewModel(moviesRepository = repo, navigator = navigator) as T
        }
    }


}