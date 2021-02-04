package by.app.slise.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Genre(
        @SerialName("id")
        val id: Int,

        @SerialName("name")
        val name: String
) {
    override fun toString(): String {
        return name
    }
}