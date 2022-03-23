package com.bselzer.gw2.v2.model.guild.team

import com.bselzer.gw2.v2.model.enumeration.wrapper.TeamMemberRole
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildTeamMember(
    /**
     * The name of the member.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/members">the wiki</a>
     */
    @SerialName("name")
    val name: String = "",

    @SerialName("role")
    val role: TeamMemberRole = TeamMemberRole()
)