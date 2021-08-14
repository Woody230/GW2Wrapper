package com.bselzer.library.gw2.v2.model.common.item

import com.bselzer.library.gw2.v2.model.common.item.detail.ArmorDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Armor")
data class ArmorItem(
    @SerialName("details")
    val details: ArmorDetails = ArmorDetails()
) : Item()