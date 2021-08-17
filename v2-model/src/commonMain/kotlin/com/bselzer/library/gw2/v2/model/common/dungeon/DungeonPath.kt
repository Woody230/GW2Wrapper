package com.bselzer.library.gw2.v2.model.common.dungeon

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DungeonPath(
    /**
     * The name of the path.
     */
    // TODO enum and extension
    @SerialName("id")
    override val id: String = "",

    @SerialName("type")
    val type: String = ""
) : Identifiable<String>