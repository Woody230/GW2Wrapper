package com.bselzer.gw2.v2.model.profession

import com.bselzer.gw2.v2.model.enumeration.wrapper.TrainingCategory
import com.bselzer.gw2.v2.model.profession.track.TrainingTrack
import com.bselzer.ktx.value.identifier.Identifiable
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
    val category: TrainingCategory = TrainingCategory(),

    @SerialName("name")
    val name: String = "",

    @SerialName("track")
    val tracks: List<TrainingTrack> = emptyList()
) : Identifiable<TrainingId, Int>
