package com.bselzer.library.gw2.model.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameBuild(
    @SerialName("id")
    val id: Long
)
