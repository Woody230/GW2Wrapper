package com.bselzer.gw2.v2.model.world

import com.bselzer.gw2.v2.model.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class World(
    @SerialName("id")
    override val id: WorldId = WorldId(),

    @SerialName("name")
    val name: String = "",

    @SerialName("population")
    val population: String = ""
) : Identifiable<Int>