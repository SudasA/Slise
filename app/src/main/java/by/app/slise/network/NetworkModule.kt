package by.app.slise.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create

object NetworkModule {

    private val baseUrl = "https://api.themoviedb.org/"

    private  val json = Json {
        prettyPrint = true
        ignoreUnknownKeys = true
    }

    private val contentType = "application/json".toMediaType()

    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(json.asConverterFactory(contentType))
        .client(client)
        .build()

    val tmdbEndpoints: TmdbEndpoints = retrofit.create()
}