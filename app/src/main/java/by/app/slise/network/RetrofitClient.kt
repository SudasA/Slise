package by.app.slise.network

import by.app.slise.BuildConfig
import by.app.slise.networkConnectionInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.Retrofit.*

object RetrofitClient {

    private val  authInterceptor = Interceptor{ chain ->
        val originalRequest = chain.request()
        val originalHttpUrl = originalRequest.url
        val newUrl = originalHttpUrl.newBuilder()
            .addQueryParameter("api_key", "a0b0cb7c53f94463d7503df7db534949")
            .build()
        val newRequest = originalRequest.newBuilder()
            .url(newUrl)
            .build()
        chain.proceed(newRequest)
    }

    private val okHttpClient = OkHttpClient().newBuilder()
            .addNetworkInterceptor(authInterceptor)
            .addInterceptor(networkConnectionInterceptor)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

    private val contentType = "application/json".toMediaType()

    private val json = Json {
        ignoreUnknownKeys = true
    }

    @Suppress("EXPERIMENTAL_API_USAGE")
    private val retrofit: Retrofit = Builder()
            .client(okHttpClient)
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()

    val moviesApi: MoviesApi = retrofit.create(MoviesApi::class.java)
}