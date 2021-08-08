package com.bselzer.library.gw2.v2.model.extension.common.enumeration.dungeon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class DungeonPathType
{
    @SerialName("Story")
    STORY,

    @SerialName("Explorable")
    EXPLORABLE
}