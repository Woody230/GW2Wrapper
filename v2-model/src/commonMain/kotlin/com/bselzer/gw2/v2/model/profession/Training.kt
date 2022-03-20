package com.bselzer.gw2.v2.model.profession

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.profession.track.TrainingTrack
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Training(
    @SerialName("id")
    override val id: TrainingId = TrainingId(),

    /**
     * The type of training.
     */
    @SerialName("category")
    val category: String = "",

    @SerialName("name")
    val name: String = "",

    @SerialName("track")
    val tracks: List<TrainingTrack> = emptyList()
) : Identifiable<Int>
