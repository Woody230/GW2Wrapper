package com.bselzer.library.gw2.v2.model.common.wvw.match

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MapObjective(
    @SerialName("id")
    override val id: String = "",

    @SerialName("type")
    val type: String = "",

    @SerialName("owner")
    val owner: String = "",

    @SerialName("last_flipped")
    val lastFlippedAt: Instant? = null,

    @SerialName("claimed_by")
    val claimedBy: String? = null,

    @SerialName("claimed_at")
    val claimedAt: Instant? = null,

    @SerialName("points_tick")
    val pointsPerTick: Int = 0,

    @SerialName("points_capture")
    val pointsOnCapture: Int = 0,

    @SerialName("guild_upgrades")
    val guildUpgradeIds: List<Int> = emptyList(),

    @SerialName("yaks_delivered")
    val yaksDelivered: Int = 0
) : Identifiable<String>