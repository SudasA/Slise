package by.app.slise.moviedetails

import androidx.lifecycle.*
import by.app.slise.data.MovieRepositoryImpl
import by.app.slise.model.Actor
import by.app.slise.model.Movie

import kotlinx.coroutines.launch

class MoviesDetailsViewModel(
    private val movieId: Int
) : ViewModel() {

    private val _mutableLoadingState = MutableLiveData(false)
    private val _mutableCurrentMovie = MutableLiveData<Movie>()
    private val _mutableActorsList = MutableLiveData<List<Actor>>(emptyList())

    val loadingState: LiveData<Boolean> get() = _mutableLoadingState
    val currentMovie: LiveData<Movie> get() = _mutableCurrentMovie
    val actorsList: LiveData<List<Actor>> get() = _mutableActorsList

    private val repository = MovieRepositoryImpl()

    init {
        viewModelScope.launch {

            _mutableLoadingState.value = true

            val movie = repository.getMovieById(movieId)
            _mutableCurrentMovie.value = movie

            val actors = repository.getMovieActorsById(movieId).actors
            _mutableActorsList.value = actors

            _mutableLoadingState.value = false

        }
    }
}