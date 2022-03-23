package com.bselzer.gw2.v2.model.dungeon.path

import com.bselzer.gw2.v2.model.enumeration.wrapper.DungeonPathType
import com.bselzer.gw2.v2.model.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DungeonPath(
    @SerialName("id")
    override val id: DungeonPathId = DungeonPathId(),

    @SerialName("type")
    val type: DungeonPathType = DungeonPathType()
) : Identifiable<String>