package by.app.slise.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieId (
        @SerialName("id")
        internal val id: Int
)