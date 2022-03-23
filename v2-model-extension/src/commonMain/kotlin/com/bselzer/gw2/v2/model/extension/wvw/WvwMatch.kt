package com.bselzer.gw2.v2.model.extension.wvw

import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner.*
import com.bselzer.gw2.v2.model.world.WorldId
import com.bselzer.gw2.v2.model.wvw.map.WvwMap
import com.bselzer.gw2.v2.model.wvw.map.WvwMapObjective
import com.bselzer.gw2.v2.model.wvw.match.WvwMatch
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
 * @return the [WvwObjectiveOwner] associated with the [world]
 */
fun WvwMatch.owner(world: WorldId): WvwObjectiveOwner = when {
    allWorlds.red.contains(world) -> RED
    allWorlds.blue.contains(world) -> BLUE
    allWorlds.green.contains(world) -> GREEN
    else -> NEUTRAL
}

/**
 * @return all the world ids associated with the match
 */
fun WvwMatch.allWorlds(): List<WorldId> = allWorlds.red + allWorlds.blue + allWorlds.green

/**
 * @return all the world ids linked together that are associated with the [owner]
 */
fun WvwMatch.linkedWorlds(owner: WvwObjectiveOwner) = when (owner) {
    RED -> allWorlds.red
    BLUE -> allWorlds.blue
    GREEN -> allWorlds.green
    else -> emptyList()
}

/**
 * @return the main world id associated with the [.owner]
 */
fun WvwMatch.mainWorld(owner: WvwObjectiveOwner): WorldId? = when (owner) {
    RED -> worlds.red
    BLUE -> worlds.blue
    GREEN -> worlds.green
    else -> null
}

/**
 * @return the points that would currently be awarded to each [WvwObjectiveOwner] if a tick passed
 */
fun WvwMatch.pointsPerTick(): Map<WvwObjectiveOwner?, Int> {
    val ppt = mutableMapOf<WvwObjectiveOwner?, Int>()
    maps.forEach { map -> ppt.merge(map.pointsPerTick()) }
    return ppt
}

/**
 * @return the total number of victory points earned through all of the skirmishes for each [WvwObjectiveOwner]
 */
fun WvwMatch.victoryPoints(): Map<WvwObjectiveOwner, Int> = victoryPoints.count()

/**
 * @return the score within the [WvwMatch.scores] for each [WvwObjectiveOwner]
 */
fun WvwMatch.scores(): Map<WvwObjectiveOwner, Int> = scores.count()

/**
 * @return the deaths within the [WvwMatch.deaths] for each [WvwObjectiveOwner]
 */
fun WvwMatch.deaths(): Map<WvwObjectiveOwner, Int> = deaths.count()

/**
 * @return the kills within the [WvwMatch.kills] for each [WvwObjectiveOwner]
 */
fun WvwMatch.kills(): Map<WvwObjectiveOwner, Int> = kills.count()