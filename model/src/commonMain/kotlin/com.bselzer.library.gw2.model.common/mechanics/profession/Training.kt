package com.bselzer.library.gw2.model.common.mechanics.profession

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Training(
    @SerialName("id")
    val categoryId: Int = 0,

    @SerialName("category")
    val category: String = "",

    @SerialName("name")
    val categoryName: String = "",

    @SerialName("track")
    val tracks: List<TrainingTrack> = emptyList()
)
