package com.bselzer.gw2.v2.model.dungeon

import com.bselzer.gw2.v2.model.dungeon.path.DungeonPath
import com.bselzer.gw2.v2.model.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Dungeon(
    @SerialName("id")
    override val id: DungeonId = DungeonId(),

    @SerialName("paths")
    val paths: List<DungeonPath> = emptyList()
) : Identifiable<String>