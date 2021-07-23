package com.bselzer.library.gw2.model.common.mechanics.profession.training

import com.bselzer.library.gw2.model.common.mechanics.profession.training.track.Track
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Training(
    @SerialName("id")
    val categoryId: Int = 0,

    @SerialName("category")
    val category: TrainingCategory? = null,

    @SerialName("name")
    val categoryName: String = "",

    @SerialName("track")
    val tracks: List<Track> = emptyList()
)
