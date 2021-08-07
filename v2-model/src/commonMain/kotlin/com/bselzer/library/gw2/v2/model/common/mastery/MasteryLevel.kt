package com.bselzer.library.gw2.v2.model.common.mastery

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MasteryLevel(
    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    @SerialName("instruction")
    val instructions: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    /**
     * The number of mastery points required to unlock this level.
     */
    @SerialName("point_count")
    val pointCost: Int = 0,

    /**
     * The amount of experience required to unlock this level.
     */
    @SerialName("exp_cost")
    val experienceCost: Int = 0
)