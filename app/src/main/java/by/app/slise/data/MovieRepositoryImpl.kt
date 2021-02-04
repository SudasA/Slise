package by.app.slise.data

import by.app.slise.db
import by.app.slise.model.Movie
import by.app.slise.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepositoryImpl : MovieRepository {

    private val movieDao = db.movieDao

    override suspend fun getPopularMoviesByPage(page: Int) = withContext(Dispatchers.IO) {
        RetrofitClient.moviesApi.getPopularMoviesByPage(page)
    }

    override suspend fun getMovieById(movieId: Int) = withContext(Dispatchers.IO) {
        RetrofitClient.moviesApi.getMovieById(movieId)
    }

    override suspend fun getMovieActorsById(movieId: Int) = withContext(Dispatchers.IO) {
        RetrofitClient.moviesApi.getMovieActorsById(movieId)
    }

    override suspend fun saveMovie(movie: Movie) = withContext(Dispatchers.IO){
        movieDao.insert(movie)
    }

    override suspend fun getSavedMovies() = withContext(Dispatchers.IO){
        movieDao.getAll()
    }
}