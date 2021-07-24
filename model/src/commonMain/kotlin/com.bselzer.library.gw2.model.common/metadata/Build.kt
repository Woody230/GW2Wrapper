package com.bselzer.library.gw2.model.common.metadata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Build(
    @SerialName("id")
    val id: Int
)
