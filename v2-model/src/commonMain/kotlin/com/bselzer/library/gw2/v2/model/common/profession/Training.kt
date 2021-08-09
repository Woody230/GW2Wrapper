package com.bselzer.library.gw2.v2.model.common.profession

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Training(
    @SerialName("id")
    val id: Int = 0,

    /**
     * The type of training.
     */
    @SerialName("category")
    val category: String = "",

    @SerialName("name")
    val name: String = "",

    @SerialName("track")
    val tracks: List<TrainingTrack> = emptyList()
)
