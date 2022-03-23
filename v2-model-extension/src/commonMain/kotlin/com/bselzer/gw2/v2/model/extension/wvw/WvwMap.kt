package com.bselzer.gw2.v2.model.extension.wvw

import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.enumeration.extension.enumValueOrNull
import com.bselzer.gw2.v2.model.wvw.map.WvwMap

/**
 * @return the points that would currently be awarded to each [WvwObjectiveOwner] if a tick passed
 */
fun WvwMap.pointsPerTick(): Map<WvwObjectiveOwner?, Int> {
    val ppt = mutableMapOf<WvwObjectiveOwner?, Int>()
    objectives.forEach { objective ->
        val owner = objective.owner.enumValueOrNull()
        ppt[owner] = ppt.getOrElse(owner) { 0 }.plus(objective.pointsPerTick)
    }
    return ppt
}

/**
 * @return the score within the [WvwMap.scores] for each [WvwObjectiveOwner]
 */
fun WvwMap.scores(): Map<WvwObjectiveOwner, Int> = scores.count()

/**
 * @return the deaths within the [WvwMap.deaths] for each [WvwObjectiveOwner]
 */
fun WvwMap.deaths(): Map<WvwObjectiveOwner, Int> = deaths.count()

/**
 * @return the kills within the [WvwMap.kills] for each [WvwObjectiveOwner]
 */
fun WvwMap.kills(): Map<WvwObjectiveOwner, Int> = kills.count()