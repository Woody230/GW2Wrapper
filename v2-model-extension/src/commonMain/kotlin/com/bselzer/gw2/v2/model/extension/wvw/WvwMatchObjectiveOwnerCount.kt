package com.bselzer.gw2.v2.model.extension.wvw

import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.extension.wvw.ObjectiveOwnerCount.count
import com.bselzer.gw2.v2.model.extension.wvw.ObjectiveOwnerCount.merge
import com.bselzer.gw2.v2.model.extension.wvw.WvwMapObjectiveOwnerCount.Companion.pointsPerTick
import com.bselzer.gw2.v2.model.wvw.match.WvwMatch

data class WvwMatchObjectiveOwnerCount(
    /**
     * The points that would currently be awarded to each [WvwObjectiveOwner] if a tick passed
     */
    val pointsPerTick: Map<WvwObjectiveOwner, Int>,

    /**
     * The total number of victory points earned through all of the skirmishes for each [WvwObjectiveOwner]
     */
    val victoryPoints: Map<WvwObjectiveOwner, Int>,

    /**
     * The score within the [WvwMatch.scores] for each [WvwObjectiveOwner]
     */
    val scores: Map<WvwObjectiveOwner, Int>,

    /**
     * The deaths within the [WvwMatch.deaths] for each [WvwObjectiveOwner]
     */
    val deaths: Map<WvwObjectiveOwner, Int>,

    /**
     * The kills within the [WvwMatch.kills] for each [WvwObjectiveOwner]
     */
    val kills: Map<WvwObjectiveOwner, Int>,
) {
    constructor(match: WvwMatch) : this(
        pointsPerTick = match.pointsPerTick(),
        victoryPoints = match.victoryPoints.count(),
        scores = match.scores.count(),
        deaths = match.deaths.count(),
        kills = match.kills.count()
    )

    private companion object {
        /**
         * @return the points that would currently be awarded to each [WvwObjectiveOwner] if a tick passed
         */
        fun WvwMatch.pointsPerTick(): Map<WvwObjectiveOwner, Int> {
            val ppt = mutableMapOf<WvwObjectiveOwner, Int>()
            maps.forEach { map -> ppt.merge(map.pointsPerTick()) }
            return ppt
        }
    }
}