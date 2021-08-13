package com.bselzer.library.gw2.v2.model.common.home

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Node(
    @SerialName("id")
    val id: String = ""
)