package com.bselzer.library.gw2.v2.model.common.world

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class World(
    @SerialName("id")
    val id: Int = 0,

    @SerialName("name")
    val name: String = "",

    @SerialName("population")
    val population: String = ""
)