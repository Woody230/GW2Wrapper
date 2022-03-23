package com.bselzer.gw2.v2.model.world

import com.bselzer.gw2.v2.model.enumeration.wrapper.WorldName
import com.bselzer.gw2.v2.model.enumeration.wrapper.WorldPopulationLevel
import com.bselzer.gw2.v2.model.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class World(
    @SerialName("id")
    override val id: WorldId = WorldId(),

    @SerialName("name")
    val name: WorldName = WorldName(),

    @SerialName("population")
    val population: WorldPopulationLevel = WorldPopulationLevel()
) : Identifiable<Int>