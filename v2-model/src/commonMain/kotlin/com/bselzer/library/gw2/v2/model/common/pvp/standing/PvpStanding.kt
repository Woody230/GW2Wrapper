package com.bselzer.library.gw2.v2.model.common.pvp.standing

import com.bselzer.library.gw2.v2.model.common.pvp.season.PvpSeason
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
abstract class PvpStanding(
    @SerialName("total_points")
    val totalPoints: Int = 0,

    /**
     * The index into the [PvpSeason.divisions].
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">the wiki</a>
     */
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

        if (totalPoints != other.totalPoints) return false
        if (division != other.division) return false
        if (points != other.points) return false
        if (repeats != other.repeats) return false

        return true
    }

    override fun hashCode(): Int
    {
        var result = totalPoints
        result = 31 * result + division
        result = 31 * result + points
        result = 31 * result + repeats
        return result
    }
}