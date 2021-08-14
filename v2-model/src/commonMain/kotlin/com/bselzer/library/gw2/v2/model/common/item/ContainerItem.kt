package com.bselzer.library.gw2.v2.model.common.item

import com.bselzer.library.gw2.v2.model.common.item.detail.ContainerDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Container")
data class ContainerItem(
    @SerialName("details")
    val details: ContainerDetails = ContainerDetails()
) : Item()