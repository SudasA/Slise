package by.app.slise.network

import com.example.slisetwo.model.response.movie.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface TmdbEndpoints {

    @GET("/3/movie/popular")
    suspend fun getMovies(@Query("api_key") key: String): MovieListResponse

}