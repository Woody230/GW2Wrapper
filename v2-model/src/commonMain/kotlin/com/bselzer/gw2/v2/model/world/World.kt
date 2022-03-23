package com.bselzer.gw2.v2.model.world

import com.bselzer.gw2.v2.model.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class World(
    @SerialName("id")
    override val id: WorldId = WorldId(),

    @SerialName("name")
    val name: com.bselzer.gw2.v2.model.wrapper.WorldName = com.bselzer.gw2.v2.model.wrapper.WorldName(),

    @SerialName("population")
    val population: com.bselzer.gw2.v2.model.wrapper.WorldPopulationLevel = com.bselzer.gw2.v2.model.wrapper.WorldPopulationLevel()
) : Identifiable<Int>