package com.bselzer.library.gw2.v2.model.guild.upgrade.cost

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
abstract class GuildUpgradeCost(
    /**
     * The amount required.
     */
    @SerialName("count")
    val count: Int = 0
)
{
    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as GuildUpgradeCost

        if (count != other.count) return false

        return true
    }

    override fun hashCode(): Int
    {
        return count
    }
}