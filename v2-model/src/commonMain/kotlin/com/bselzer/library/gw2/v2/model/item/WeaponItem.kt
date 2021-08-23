package com.bselzer.library.gw2.v2.model.item

import com.bselzer.library.gw2.v2.model.item.detail.WeaponDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Weapon")
data class WeaponItem(
    @SerialName("details")
    val details: WeaponDetails = WeaponDetails()
) : Item()