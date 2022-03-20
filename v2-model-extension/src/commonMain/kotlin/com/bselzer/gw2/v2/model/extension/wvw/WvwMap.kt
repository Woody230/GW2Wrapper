package com.bselzer.gw2.v2.model.extension.wvw

import com.bselzer.gw2.v2.model.enumeration.extension.wvw.owner
import com.bselzer.gw2.v2.model.enumeration.wvw.ObjectiveOwner
import com.bselzer.gw2.v2.model.wvw.map.WvwMap

/**
 * @return the points that would currently be awarded to each [ObjectiveOwner] if a tick passed
 */
fun WvwMap.pointsPerTick(): Map<ObjectiveOwner?, Int> {
    val ppt = mutableMapOf<ObjectiveOwner?, Int>()
    objectives.forEach { objective ->
        val owner = objective.owner()
        ppt[owner] = ppt.getOrElse(owner) { 0 }.plus(objective.pointsPerTick)
    }
    return ppt
}

/**
 * @return the score within the [WvwMap.scores] for each [ObjectiveOwner]
 */
fun WvwMap.scores(): Map<ObjectiveOwner, Int> = scores.count()

/**
 * @return the deaths within the [WvwMap.deaths] for each [ObjectiveOwner]
 */
fun WvwMap.deaths(): Map<ObjectiveOwner, Int> = deaths.count()

/**
 * @return the kills within the [WvwMap.kills] for each [ObjectiveOwner]
 */
fun WvwMap.kills(): Map<ObjectiveOwner, Int> = kills.count()