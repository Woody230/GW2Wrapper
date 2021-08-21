package com.bselzer.library.gw2.v2.model.enumeration.common.extension.guild

import com.bselzer.library.gw2.v2.model.common.guild.team.GuildTeamMember
import com.bselzer.library.gw2.v2.model.enumeration.common.guild.TeamMemberRole
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [GuildTeamMember.role] as a [TeamMemberRole]
 */
fun GuildTeamMember.role(): TeamMemberRole? = role.enumValueOrNull<TeamMemberRole>()