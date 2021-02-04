package by.app.slise.network

import by.app.slise.model.ActorListResponse
import by.app.slise.model.Movie
import by.app.slise.model.MovieListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MoviesApi {
    @GET("movie/popular")
    suspend fun getPopularMoviesByPage(@Query("page") page: Int): Response<MovieListResponse>

    @GET("movie/{movieId}")
    suspend fun getMovieById(@Path("movieId") movieId: Int): Movie

    @GET("movie/{movieId}/credits")
    suspend fun getMovieActorsById(@Path("movieId") movieId: Int): ActorListResponse
}