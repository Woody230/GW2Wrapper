package com.bselzer.library.gw2.v2.model.common.pvp.standing

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
abstract class PvpStanding
{
    @SerialName("total_points")
    abstract val totalPoints: Int

    /**
     * The index into the /v2/pvp/seasons divisions.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">the wiki</a>
     */
    // TODO reference object instead of endpoint
    @SerialName("division")
    abstract val division: Int

    @SerialName("points")
    abstract val points: Int

    /**
     * The number of times the account has maxed out the repeat division.
     */
    @SerialName("repeats")
    abstract val repeats: Int
}