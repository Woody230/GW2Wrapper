package com.bselzer.library.gw2.v2.model.title

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Title(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("name")
    val name: String = "",

    /**
     * The ids of the achievements required to grant the title.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">the wiki</a>
     */
    @SerialName("achievements")
    val achievementIds: List<Int> = emptyList(),

    /**
     * The number of achievement points required to grant the title.
     *
     * Null if achievement points are not required
     */
    @SerialName("ap_required")
    val achievementPointsRequired: Int? = null
) : Identifiable<Int>