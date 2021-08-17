package com.bselzer.library.gw2.v2.model.common.guild

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildRank(
    /**
     * The name of the rank given by the leader.
     */
    @SerialName("id")
    override val id: String = "",

    /**
     * The sorting order. The lower the value, the higher the priority.
     */
    @SerialName("order")
    val order: Int = Int.MAX_VALUE,

    /**
     * The ids of the permissions.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/permissions">the wiki</a>
     */
    @SerialName("permissions")
    val permissions: List<String> = emptyList(),

    @SerialName("icon")
    val iconLink: String = ""
) : Identifiable<String>