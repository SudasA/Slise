package by.app.slise.movies

import androidx.lifecycle.*
import by.app.slise.data.MovieRepository
import by.app.slise.model.Movie
import kotlinx.coroutines.launch

class MovieListViewModel(
       movieRepository: MovieRepository
): ViewModel() {

    val repository = movieRepository

    private val _movies = MutableLiveData<List<Movie>>()
    val movies : LiveData<List<Movie>>
    get() = _movies

    init {
        loadMoviesList()
    }

    private fun loadMoviesList() {
       viewModelScope.launch {
           _movies.value = repository.loadMovies()
       }
    }
}

class MovieListViewModelFactory(private  val movieRepository: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieRepository::class.java)) {
            return MovieListViewModel(movieRepository ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

