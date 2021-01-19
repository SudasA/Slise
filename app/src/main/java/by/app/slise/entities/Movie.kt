package by.app.slise.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int? = null,
    val name: String,
    val thumbnail: String?,
    val voteCount : String,
    val average: Float,
    val adult: Boolean,
    val releaseDate: String,
    val genreIds: MutableList<String>
    )