package com.bselzer.gw2.v2.model.mastery

import com.bselzer.gw2.v2.model.enumeration.wrapper.RegionType
import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.wrapper.ImageLink
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Mastery(
    @SerialName("id")
    override val id: MasteryId = MasteryId(),

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
    val backgroundLink: ImageLink = ImageLink(),

    @SerialName("region")
    val region: RegionType = RegionType(),

    @SerialName("levels")
    val levels: List<MasteryLevel> = emptyList()
) : Identifiable<Int>