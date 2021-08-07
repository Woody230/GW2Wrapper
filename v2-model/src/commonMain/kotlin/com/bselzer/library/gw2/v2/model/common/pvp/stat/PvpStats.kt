package com.bselzer.library.gw2.v2.model.common.pvp.stat

import com.bselzer.library.gw2.v2.annotation.common.scope.Permission
import com.bselzer.library.gw2.v2.annotation.common.scope.Requirement
import com.bselzer.library.gw2.v2.annotation.common.scope.Scope
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PVP)
data class PvpStats(
    /**
     * The account's PvP rank.
     */
    @SerialName("pvp_rank")
    val rank: Int = 0,

    /**
     * The account's PvP rank points.
     */
    @SerialName("pvp_rank_points")
    val rankPoints: Int = 0,

    /**
     * The number of times the player has leveled up since rank 80.
     */
    @SerialName("pvp_rank_rollovers")
    val rankRollovers: Int = 0,

    /**
     * The total count of wins and losses.
     */
    @SerialName("aggregate")
    val totalAggregate: StatAggregate = StatAggregate(),

    /**
     * The profession names mapped to an aggregate.
     */
    @SerialName("professions")
    val professionAggregate: Map<String, StatAggregate> = emptyMap(),

    /**
     * The ladder types mapped to an aggregate.
     */
    @SerialName("ladders")
    val ladderAggregate: Map<String, StatAggregate> = emptyMap()
)