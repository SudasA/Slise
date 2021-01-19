package by.app.slise.entities

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(tableName = "actors",
foreignKeys = [ForeignKey(
        entity = Movie::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("filmId"),
        onDelete = CASCADE
)])
data class Actors(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "actors_id")
        val id: Int,
        val filmId: Int,
        val actorName: String,
        @Embedded
        val actorView: String,
)