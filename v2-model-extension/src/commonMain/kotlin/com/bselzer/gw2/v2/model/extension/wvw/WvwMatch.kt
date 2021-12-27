package com.bselzer.gw2.v2.model.extension.wvw

import com.bselzer.gw2.v2.model.enumeration.extension.wvw.owner
import com.bselzer.gw2.v2.model.enumeration.wvw.ObjectiveOwner
import com.bselzer.gw2.v2.model.enumeration.wvw.ObjectiveOwner.*
import com.bselzer.gw2.v2.model.world.World
import com.bselzer.gw2.v2.model.wvw.match.WvwMap
import com.bselzer.gw2.v2.model.wvw.match.WvwMapObjective
import com.bselzer.gw2.v2.model.wvw.match.WvwMatch
import com.bselzer.gw2.v2.model.wvw.match.WvwWorldCount
import com.bselzer.gw2.v2.model.wvw.objective.WvwObjective

/**
 * @return the objective from the match endpoint that matches the objective from the objectives endpoint
 */
fun WvwMatch?.objective(objective: WvwObjective?): WvwMapObjective? = objective?.let {
    this?.map(objective)?.objectives?.firstOrNull { match -> match.id == objective.id }
}

/**
 * @return the map associated with the [objective]
 */
fun WvwMatch.map(objective: WvwObjective): WvwMap? = this.maps.firstOrNull { map -> map.id == objective.mapId }

/**
 * @return the [ObjectiveOwner] associated with the [world]
 */
fun WvwMatch.owner(world: World): ObjectiveOwner {
    val id = world.id
    return when {
        allWorlds.red.contains(id) -> RED
        allWorlds.blue.contains(id) -> BLUE
        allWorlds.green.contains(id) -> GREEN
        else -> NEUTRAL
    }
}

/**
 * @return all the world ids associated with the match
 */
fun WvwMatch.allWorlds(): List<Int> = allWorlds.red + allWorlds.blue + allWorlds.green

/**
 * @return all the world ids linked together that are associated with the [owner]
 */
fun WvwMatch.linkedWorlds(owner: ObjectiveOwner) = when (owner) {
    RED -> allWorlds.red
    BLUE -> allWorlds.blue
    GREEN -> allWorlds.green
    else -> emptyList()
}

/**
 * @return the main world id associated with the [.owner]
 */
fun WvwMatch.mainWorld(owner: ObjectiveOwner): Int? = when (owner) {
    RED -> worlds.red
    BLUE -> worlds.blue
    GREEN -> worlds.green
    else -> null
}

/**
 * @return the points that would currently be awarded to each [ObjectiveOwner] if a tick passed
 */
fun WvwMatch.pointsPerTick(): Map<ObjectiveOwner?, Int> {
    val ppt = mutableMapOf<ObjectiveOwner?, Int>()
    maps.flatMap { map -> map.objectives }.forEach { objective ->
        val owner = objective.owner()
        ppt[owner] = (ppt[owner] ?: 0).plus(objective.pointsPerTick)
    }
    return ppt
}

/**
 * @return the total number of victory points earned through all of the skirmishes for each [ObjectiveOwner]
 */
fun WvwMatch.victoryPoints(): Map<ObjectiveOwner, Int> = victoryPoints.count()

/**
 * @return the score within the [WvwMatch.scores] for each [ObjectiveOwner]
 */
fun WvwMatch.scores(): Map<ObjectiveOwner, Int> = scores.count()

/**
 * @return the deaths within the [WvwMatch.deaths] for each [ObjectiveOwner]
 */
fun WvwMatch.deaths(): Map<ObjectiveOwner, Int> = deaths.count()

/**
 * @return the kills within the [WvwMatch.kills] for each [ObjectiveOwner]
 */
fun WvwMatch.kills(): Map<ObjectiveOwner, Int> = kills.count()

/**
 * @return a mapping of the owner to the [WvwWorldCount] value
 */
private fun WvwWorldCount.count(): Map<ObjectiveOwner, Int> = mapOf(
    BLUE to blue,
    GREEN to green,
    RED to red
)