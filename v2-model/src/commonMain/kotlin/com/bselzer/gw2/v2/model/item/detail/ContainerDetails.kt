package com.bselzer.gw2.v2.model.item.detail

import com.bselzer.gw2.v2.model.enumeration.wrapper.ContainerDetailType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContainerDetails(
    @SerialName("type")
    val type: ContainerDetailType = ContainerDetailType()
)