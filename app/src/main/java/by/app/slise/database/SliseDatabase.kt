package by.app.slise.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.app.slise.dao.ActorDao
import by.app.slise.dao.MoviesDao
import by.app.slise.entities.Actors
import by.app.slise.entities.Movie

/*

@Database(entities = [Movie::class, Actors::class], version = 1)
abstract class SliseDatabase : RoomDatabase() {

    abstract fun movieDao(): MoviesDao
    abstract fun actorsDao(): ActorDao

    companion object {
        private const val DATABASE_NAME = "Movies.db"

       fun create (applicationContext: Context) : SliseDatabase =
            Room.databaseBuilder(
                applicationContext,
                SliseDatabase::class.java,
                SliseDatabase.DATABASE_NAME
            )   .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
*/