package com.bselzer.library.gw2.v2.model.common.profession.track

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
abstract class TrainingTrack(
    @SerialName("cost")
    val cost: Int = 0
)
{
    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as TrainingTrack

        if (cost != other.cost) return false

        return true
    }

    override fun hashCode(): Int
    {
        return cost
    }
}