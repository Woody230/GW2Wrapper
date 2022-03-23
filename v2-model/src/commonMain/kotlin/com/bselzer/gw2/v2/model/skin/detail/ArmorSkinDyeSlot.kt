package com.bselzer.gw2.v2.model.skin.detail

import com.bselzer.gw2.v2.model.color.DyeColorId
import com.bselzer.gw2.v2.model.enumeration.wrapper.MaterialType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArmorSkinDyeSlot(
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
    val material: MaterialType = MaterialType()
)