package by.app.slise.db

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import by.app.slise.model.Movie


@Database(entities = [Movie::class], version = 1)
@TypeConverters(GenreConverter::class)
abstract class MovieDatabase : RoomDatabase() {

    abstract val movieDao: MovieDao

    companion object {
        fun create(appContext: Context): MovieDatabase = Room.databaseBuilder(
                appContext,
                MovieDatabase::class.java,
                MovieDbContract.DATABASE_NAME
        )
                .fallbackToDestructiveMigration()
                .build()
    }
}