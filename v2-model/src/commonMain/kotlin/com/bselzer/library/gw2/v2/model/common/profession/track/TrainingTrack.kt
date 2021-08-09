package com.bselzer.library.gw2.v2.model.common.profession.track

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
abstract class TrainingTrack
{
    @SerialName("cost")
    abstract val cost: Int
}