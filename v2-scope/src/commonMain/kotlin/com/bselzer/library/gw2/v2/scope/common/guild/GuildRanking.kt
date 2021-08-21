package com.bselzer.library.gw2.v2.scope.common.guild

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class GuildRanking
{
    /**
     * The owner of the token is a leader of the designated guild.
     */
    @SerialName("leader")
    LEADER,

    /**
     * The owner of the token is a member of the designated guild.
     */
    @SerialName("member")
    MEMBER
}