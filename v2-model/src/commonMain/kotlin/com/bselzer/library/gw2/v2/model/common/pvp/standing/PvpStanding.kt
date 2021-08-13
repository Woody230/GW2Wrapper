package com.bselzer.library.gw2.v2.model.common.pvp.standing

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
open class PvpStanding(
    @SerialName("type")
    val type: String = "",

    @SerialName("total_points")
    val totalPoints: Int = 0,

    /**
     * The index into the /v2/pvp/seasons divisions.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">the wiki</a>
     */
    // TODO reference object instead of endpoint
    @SerialName("division")
    val division: Int = 0,

    @SerialName("points")
    val points: Int = 0,

    /**
     * The number of times the account has maxed out the repeat division.
     */
    @SerialName("repeats")
    val repeats: Int = 0
)
{
    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as PvpStanding

        if (type != other.type) return false
        if (totalPoints != other.totalPoints) return false
        if (division != other.division) return false
        if (points != other.points) return false
        if (repeats != other.repeats) return false

        return true
    }

    override fun hashCode(): Int
    {
        var result = type.hashCode()
        result = 31 * result + totalPoints
        result = 31 * result + division
        result = 31 * result + points
        result = 31 * result + repeats
        return result
    }
}