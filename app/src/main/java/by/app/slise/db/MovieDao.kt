package by.app.slise.db

import androidx.room.*
import by.app.slise.model.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: Movie)

    @Query("select * from movies")
    fun getAll(): List<Movie>

    @Query("DELETE FROM movies WHERE _id = :id")
    fun delete(id: Int?)
}