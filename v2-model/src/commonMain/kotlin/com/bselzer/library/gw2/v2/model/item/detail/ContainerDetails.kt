package com.bselzer.library.gw2.v2.model.item.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContainerDetails(
    @SerialName("type")
    val type: String = ""
)