package com.bselzer.gw2.v2.model.extension.wvw

import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.enumeration.extension.enumValueOrNull
import com.bselzer.gw2.v2.model.wvw.map.WvwMap

data class WvwMapObjectiveOwnerCount(
    /**
     * The points that would currently be awarded to each [WvwObjectiveOwner] if a tick passed
     */
    override val pointsPerTick: Map<WvwObjectiveOwner, Int>,

    /**
     * The score within the [WvwMap.scores] for each [WvwObjectiveOwner]
     */
    override val scores: Map<WvwObjectiveOwner, Int>,

    /**
     * The deaths within the [WvwMap.deaths] for each [WvwObjectiveOwner]
     */
    override val deaths: Map<WvwObjectiveOwner, Int>,

    /**
     * The kills within the [WvwMap.kills] for each [WvwObjectiveOwner]
     */
    override val kills: Map<WvwObjectiveOwner, Int>
) : ObjectiveOwnerCount {
    constructor(map: WvwMap) : this(
        pointsPerTick = map.pointsPerTick(),
        scores = map.scores.count(),
        deaths = map.deaths.count(),
        kills = map.kills.count()
    )

    internal companion object {
        /**
         * @return the points that would currently be awarded to each [WvwObjectiveOwner] if a tick passed
         */
        fun WvwMap.pointsPerTick(): Map<WvwObjectiveOwner, Int> {
            val ppt = mutableMapOf<WvwObjectiveOwner, Int>()
            objectives.forEach { objective ->
                val owner = objective.owner.enumValueOrNull() ?: WvwObjectiveOwner.NEUTRAL
                ppt[owner] = ppt.getOrElse(owner) { 0 }.plus(objective.pointsPerTick)
            }
            return ppt
        }
    }
}