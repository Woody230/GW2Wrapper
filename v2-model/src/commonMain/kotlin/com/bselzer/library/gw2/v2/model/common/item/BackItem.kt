package com.bselzer.library.gw2.v2.model.common.item

import com.bselzer.library.gw2.v2.model.common.item.detail.BackDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Back")
data class BackItem(
    @SerialName("details")
    val details: BackDetails = BackDetails()
) : Item()