package by.app.slise.model

import kotlinx.serialization.SerialName


@kotlinx.serialization.Serializable
data class Actor(
        @SerialName("id")
        val id: Int,

        @SerialName("name")
        val name: String,

        @SerialName("profile_path")
        val picture: String?
)