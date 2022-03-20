package com.bselzer.gw2.v2.model.guild.rank

import com.bselzer.gw2.v2.model.guild.permission.GuildPermissionId
import com.bselzer.gw2.v2.model.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildRank(
    /**
     * The name of the rank given by the leader.
     */
    @SerialName("id")
    override val id: GuildRankId = GuildRankId(),

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
    val permissions: List<GuildPermissionId> = emptyList(),

    @SerialName("icon")
    val iconLink: String = ""
) : Identifiable<String>