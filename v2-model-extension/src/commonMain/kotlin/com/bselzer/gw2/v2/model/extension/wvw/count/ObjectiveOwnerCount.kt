package com.bselzer.gw2.v2.model.extension.wvw.count

import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.enumeration.extension.enumValueOrNull
import com.bselzer.gw2.v2.model.extension.wvw.count.contestedarea.ContestedAreas
import com.bselzer.gw2.v2.model.wvw.map.WvwMapObjective
import com.bselzer.gw2.v2.model.wvw.world.WvwWorldCount

interface ObjectiveOwnerCount {
    /**
     * The points that would currently be awarded to each [WvwObjectiveOwner] if a tick passed
     */
    val pointsPerTick: Map<WvwObjectiveOwner, Int>

    /**
     * The score for each [WvwObjectiveOwner]
     */
    val scores: Map<WvwObjectiveOwner, Int>

    /**
     * The deaths for each [WvwObjectiveOwner]
     */
    val deaths: Map<WvwObjectiveOwner, Int>

    /**
     * The kills for each [WvwObjectiveOwner]
     */
    val kills: Map<WvwObjectiveOwner, Int>

    /**
     * The objectives collected based on their owner and type.
     */
    val contestedAreas: ContestedAreas
}

/**
 * @return a mapping of the owner to the [WvwWorldCount] value
 */
fun WvwWorldCount.count(): Map<WvwObjectiveOwner, Int> = mapOf(
    WvwObjectiveOwner.BLUE to blue,
    WvwObjectiveOwner.GREEN to green,
    WvwObjectiveOwner.RED to red
)

internal fun Collection<WvwMapObjective>.pointsPerTick(): Map<WvwObjectiveOwner, Int> {
    val ppt = mutableMapOf<WvwObjectiveOwner, Int>()
    forEach { objective ->
        val owner = objective.owner.enumValueOrNull() ?: WvwObjectiveOwner.NEUTRAL
        ppt[owner] = ppt.getOrElse(owner) { 0 } + objective.pointsPerTick
    }

    return ppt
}