package by.app.slise.dao

import androidx.room.*
import by.app.slise.entities.Movie

@Dao
interface MoviesDao {
    @Query("SELECT * FROM movies")
    fun getAll(): List<Movie>

    @Insert
    fun insertAll(movies : List<Movie>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: Movie) : Int

    @Update
    fun upgrade (movie: Movie)

    @Delete
    fun delete(movie: Movie)

    @Query("DELETE FROM movies WhERE id = :filmId ")
    fun deleteById(filmId: Int)

    @Query("DELETE FROM movies")
    fun deleteAll()
}