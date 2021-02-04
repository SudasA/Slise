package by.app.slise

import android.app.Application
import by.app.slise.db.MovieDatabase
import by.app.slise.network.NetworkConnectionInterceptor

lateinit var db: MovieDatabase
lateinit var networkConnectionInterceptor: NetworkConnectionInterceptor

class App : Application() {
    companion object {
        lateinit var INSTANCE: App
    }

    init {
        INSTANCE = this
    }

    override fun onCreate() {
        super.onCreate()
        db = MovieDatabase.create(this)
        networkConnectionInterceptor = NetworkConnectionInterceptor(this)
        INSTANCE = this
    }
}