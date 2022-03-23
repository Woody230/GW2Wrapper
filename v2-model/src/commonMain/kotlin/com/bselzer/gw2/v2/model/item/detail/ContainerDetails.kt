package com.bselzer.gw2.v2.model.item.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContainerDetails(
    @SerialName("type")
    val type: com.bselzer.gw2.v2.model.wrapper.ContainerDetailType = com.bselzer.gw2.v2.model.wrapper.ContainerDetailType()
)