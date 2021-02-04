package by.app.slise.model


import by.app.slise.model.MovieId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieListResponse (
        @SerialName("page")
        val page: Int,

        @SerialName("results")
        val moviesIdList: List<MovieId>,

        @SerialName("total_pages")
        val totalPages: Int,

        @SerialName("total_results")
        val totalResults: Int
)