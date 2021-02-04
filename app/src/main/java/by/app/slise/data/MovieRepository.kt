package by.app.slise.data

import by.app.slise.model.ActorListResponse
import by.app.slise.model.Movie
import by.app.slise.model.MovieListResponse
import retrofit2.Response

interface MovieRepository {

    suspend fun getPopularMoviesByPage(page: Int): Response<MovieListResponse>

    suspend fun getMovieById(movieId: Int): Movie

    suspend fun getMovieActorsById(movieId: Int): ActorListResponse

    suspend fun saveMovie(movie: Movie)

    suspend fun getSavedMovies(): List<Movie>

}
