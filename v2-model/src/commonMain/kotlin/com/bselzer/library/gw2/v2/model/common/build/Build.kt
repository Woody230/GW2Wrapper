package com.bselzer.library.gw2.v2.model.common.build

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Build(
    @SerialName("id")
    val id: Int
)
