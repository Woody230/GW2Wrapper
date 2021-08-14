package com.bselzer.library.gw2.v2.model.common.item

import com.bselzer.library.gw2.v2.model.common.item.detail.UpgradeComponentDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("UpgradeComponent")
data class UpgradeComponentItem(
    @SerialName("details")
    val details: UpgradeComponentDetails = UpgradeComponentDetails()
) : Item()