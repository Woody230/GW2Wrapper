package com.bselzer.library.gw2.v2.model.common.mastery

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Mastery(
    @SerialName("id")
    val id: Int = 0,

    @SerialName("name")
    val name: String = "",

    /**
     * The description of the requirements.
     */
    @SerialName("requirement")
    val requirements: String = "",

    /**
     * The order of this mastery within the region.
     */
    @SerialName("order")
    val order: Int = 0,

    @SerialName("background")
    val backgroundLink: String = "",

    @SerialName("region")
    val region: String = "",

    @SerialName("levels")
    val levels: List<MasteryLevel> = emptyList()
)