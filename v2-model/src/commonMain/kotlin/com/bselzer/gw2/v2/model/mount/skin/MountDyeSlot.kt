package com.bselzer.gw2.v2.model.mount.skin

import com.bselzer.gw2.v2.model.color.DyeColorId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MountDyeSlot(
    /**
     * The id of the dye color.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    @SerialName("color_id")
    val colorId: DyeColorId = DyeColorId(),

    /**
     * The type of material.
     */
    @SerialName("material")
    val material: String = ""
)