package by.app.slise.paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import by.app.slise.data.MovieRepository
import by.app.slise.model.Movie


class MoviesDataSourceFactory(
    val repository: MovieRepository
) : DataSource.Factory<Int, Movie>() {

    private val _moviesDataSourceLiveData = MutableLiveData<MoviesDataSource>()
    val moviesDataSourceLiveData: LiveData<MoviesDataSource> get() = _moviesDataSourceLiveData

    override fun create(): DataSource<Int, Movie> {
        val moviesDataSource = MoviesDataSource(repository)
        _moviesDataSourceLiveData.postValue(moviesDataSource)
        return moviesDataSource
    }
}