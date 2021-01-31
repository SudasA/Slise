package by.app.slise.network

import retrofit2.http.GET
import retrofit2.http.Query


interface TmdbEndpoints {

    @GET("/3/movie/popular")
    suspend fun getMovies(@Query("api_key") key: String): Response

}