package com.bselzer.library.gw2.v2.model.common.guild.log

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
abstract class GuildLog(
    /**
     * The id of the log. It is only unique within the scope of the associated guild.
     */
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The date and time this log was created.
     */
    @SerialName("time")
    val createdAt: Instant = Instant.DISTANT_PAST,

    /**
     * The account name of the player who generated this log.
     *
     * Null if there is no player associated with the log.
     */
    @SerialName("user")
    val user: String? = null
) : Identifiable<Int>
{
    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as GuildLog

        if (id != other.id) return false
        if (createdAt != other.createdAt) return false
        if (user != other.user) return false

        return true
    }

    override fun hashCode(): Int
    {
        var result = id
        result = 31 * result + createdAt.hashCode()
        result = 31 * result + (user?.hashCode() ?: 0)
        return result
    }
}