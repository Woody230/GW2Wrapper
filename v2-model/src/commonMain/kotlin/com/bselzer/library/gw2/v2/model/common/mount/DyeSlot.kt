package com.bselzer.library.gw2.v2.model.common.mount

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DyeSlot(
    /**
     * The id of the dye color.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    @SerialName("color_id")
    val colorId: Int = 0,

    /**
     * The type of material.
     */
    @SerialName("material")
    val material: String = ""
)