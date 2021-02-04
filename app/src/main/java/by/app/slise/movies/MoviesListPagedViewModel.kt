package by.app.slise.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import by.app.slise.data.MovieRepositoryImpl
import by.app.slise.paging.MoviesDataSourceFactory
import by.app.slise.paging.PaginationState

class MoviesListPagedViewModel : ViewModel() {

    private val repository = MovieRepositoryImpl()
    private var moviesDataSourceFactory: MoviesDataSourceFactory = MoviesDataSourceFactory(repository)

    private val pagedConfig = PagedList.Config.Builder()
        .setPageSize(10)
        .setEnablePlaceholders(false)
        .setPrefetchDistance(4)
        .build()

    val moviesPagedLiveData = LivePagedListBuilder(moviesDataSourceFactory, pagedConfig).build()

    val paginationState: LiveData<PaginationState> =
        Transformations.switchMap(moviesDataSourceFactory.moviesDataSourceLiveData) {
            it.paginationState
        }
}