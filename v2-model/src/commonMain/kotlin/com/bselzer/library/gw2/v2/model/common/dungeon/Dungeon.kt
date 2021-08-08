package com.bselzer.library.gw2.v2.model.common.dungeon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Dungeon(
    /**
     * The name of the dungeon.
     */
    // TODO enum and extension
    @SerialName("id")
    val id: String = "",

    @SerialName("paths")
    val paths: List<DungeonPath> = emptyList()
)