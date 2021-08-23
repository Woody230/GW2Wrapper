package com.bselzer.library.gw2.v2.model.enumeration.extension.guild

import com.bselzer.library.gw2.v2.model.enumeration.guild.TeamMemberRole
import com.bselzer.library.gw2.v2.model.guild.team.GuildTeamMember
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [GuildTeamMember.role] as a [TeamMemberRole]
 */
fun GuildTeamMember.role(): TeamMemberRole? = role.enumValueOrNull<TeamMemberRole>()