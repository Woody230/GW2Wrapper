package com.bselzer.library.gw2.v2.model.common.guild

import com.bselzer.library.gw2.v2.annotation.common.scope.Permission
import com.bselzer.library.gw2.v2.annotation.common.scope.Requirement
import com.bselzer.library.gw2.v2.annotation.common.scope.Scope
import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import com.bselzer.library.gw2.v2.model.common.guild.emblem.GuildEmblem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Scope(Requirement.OPTIONAL, Permission.GUILDS)
@Serializable
data class Guild(
    /**
     * The id in the form of a UUID.
     */
    @SerialName("id")
    override val id: String = "",

    @Scope(Requirement.REQUIRED, Permission.GUILDS)
    @SerialName("level")
    val level: Int = 0,

    /**
     * The message of the day for guild members.
     */
    @Scope(Requirement.REQUIRED, Permission.GUILDS)
    @SerialName("motd")
    val messageOfTheDay: String = "",

    /**
     * The current amount of influence.
     */
    @Scope(Requirement.REQUIRED, Permission.GUILDS)
    @SerialName("influence")
    val influence: Int = 0,

    /**
     * The current aetherium level.
     */
    @Scope(Requirement.REQUIRED, Permission.GUILDS)
    @SerialName("aetherium")
    val aetherium: Int = 0,

    /**
     * The current favor level.
     */
    @Scope(Requirement.REQUIRED, Permission.GUILDS)
    @SerialName("favor")
    val favor: Int = 0,

    /**
     * The current number of members in the guild.
     */
    @Scope(Requirement.REQUIRED, Permission.GUILDS)
    @SerialName("member_count")
    val memberCount: Int = 0,

    /**
     * The maximum number of members allowed in the guild.
     */
    @Scope(Requirement.REQUIRED, Permission.GUILDS)
    @SerialName("member_capacity")
    val memberCapacity: Int = 0,

    @SerialName("name")
    val name: String = "",

    /**
     * The 2 to 4 letter tag representing the guild.
     */
    @SerialName("tag")
    val tag: String = "",

    @SerialName("emblem")
    val emblem: GuildEmblem = GuildEmblem()
) : Identifiable<String>