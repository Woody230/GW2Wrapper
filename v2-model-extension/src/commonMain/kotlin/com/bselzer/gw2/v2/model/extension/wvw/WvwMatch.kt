package com.bselzer.gw2.v2.model.extension.wvw

import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner.*
import com.bselzer.gw2.v2.model.extension.wvw.count.WvwMatchObjectiveOwnerCount
import com.bselzer.gw2.v2.model.extension.wvw.count.WvwSkirmishObjectiveOwnerCount
import com.bselzer.gw2.v2.model.guild.upgrade.GuildUpgradeId
import com.bselzer.gw2.v2.model.world.WorldId
import com.bselzer.gw2.v2.model.wvw.map.WvwMap
import com.bselzer.gw2.v2.model.wvw.map.WvwMapObjective
import com.bselzer.gw2.v2.model.wvw.match.WvwMatch
import com.bselzer.gw2.v2.model.wvw.match.skirmish.WvwSkirmishId
import com.bselzer.gw2.v2.model.wvw.objective.WvwMapObjectiveId
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
 * @return the counts for each objective owner.
 */
fun WvwMatch.objectiveOwnerCount(): WvwMatchObjectiveOwnerCount = WvwMatchObjectiveOwnerCount(this)

/**
 * @return the counts for each skirmish
 */
fun WvwMatch.skirmishObjectiveOwnerCounts(): Map<WvwSkirmishId, WvwSkirmishObjectiveOwnerCount> {
    return skirmishes.associate { skirmish -> skirmish.id to WvwSkirmishObjectiveOwnerCount(skirmish) }
}

/**
 * @return the objectives from all the maps
 */
fun WvwMatch.mapObjectives(): Collection<WvwMapObjective> = maps.flatMap { map ->
    map.objectives
}

/**
 * @return the ids of all the objectives from all maps
 */
fun WvwMatch.objectiveIds(): Collection<WvwMapObjectiveId> = mapObjectives().map { objective -> objective.id }

/**
 * @return the ids of all the guild upgrades associated with the objectives from all maps
 */
fun WvwMatch.guildUpgradeIds(): Collection<GuildUpgradeId> = maps.flatMap { map ->
    map.objectives.flatMap { objective -> objective.guildUpgradeIds }
}