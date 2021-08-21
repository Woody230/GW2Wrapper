package com.bselzer.library.gw2.v2.model.enumeration.common.guild

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class TeamMemberRole
{
    @SerialName("Captain")
    CAPTAIN,

    @SerialName("Member")
    MEMBER
}