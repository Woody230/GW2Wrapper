package com.bselzer.gw2.v2.model.item

import com.bselzer.gw2.v2.model.item.detail.ContainerDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Container")
data class ContainerItem(
    @SerialName("details")
    val details: ContainerDetails = ContainerDetails()
) : Item()