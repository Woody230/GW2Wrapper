package com.bselzer.library.gw2.model.common.wvw.match.map.objective

import com.bselzer.library.gw2.model.common.wvw.objective.ObjectiveType
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MapObjective(
    @SerialName("id")
    val id: String,

    @SerialName("type")
    val type: ObjectiveType,

    @SerialName("owner")
    val owner: MapObjectiveOwner,

    @SerialName("last_flipped")
    val lastFlippedAt: LocalDateTime? = null,

    @SerialName("claimed_by")
    val claimedBy: String? = null,

    @SerialName("claimed_at")
    val claimedAt: LocalDateTime? = null,

    @SerialName("points_tick")
    val pointsPerTick: Int = 0,

    @SerialName("points_capture")
    val pointsOnCapture: Int = 0,

    @SerialName("guild_upgrades")
    val guildUpgradeIds: List<Int> = emptyList(),

    @SerialName("yaks_delivered")
    val yaksDelivered: Int = 0
)