package by.app.slise.entities

data class Movie(
    val id: Int,
    val name: String,
    val thumbnail: String?,
    val voteCount : String,
    val average: Float,
    val adult: Boolean,
    val releaseDate: String,
    )