package com.bselzer.gw2.v2.model.wvw.map

import com.bselzer.gw2.v2.model.guild.GuildId
import com.bselzer.gw2.v2.model.guild.upgrade.GuildUpgradeId
import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.wrapper.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.wrapper.WvwObjectiveType
import com.bselzer.gw2.v2.model.wvw.objective.WvwMapObjectiveId
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwMapObjective(
    /**
     * The map identifier and objective identifier split by a dash (-).
     */
    @SerialName("id")
    override val id: WvwMapObjectiveId = WvwMapObjectiveId(),

    @SerialName("type")
    val type: WvwObjectiveType = WvwObjectiveType(),

    @SerialName("owner")
    val owner: WvwObjectiveOwner = WvwObjectiveOwner(),

    @SerialName("last_flipped")
    val lastFlippedAt: Instant? = null,

    @SerialName("claimed_by")
    val claimedBy: GuildId? = null,

    @SerialName("claimed_at")
    val claimedAt: Instant? = null,

    @SerialName("points_tick")
    val pointsPerTick: Int = 0,

    @SerialName("points_capture")
    val pointsPerCapture: Int = 0,

    @SerialName("guild_upgrades")
    val guildUpgradeIds: List<GuildUpgradeId> = emptyList(),

    @SerialName("yaks_delivered")
    val yaksDelivered: Int = 0
) : Identifiable<String>