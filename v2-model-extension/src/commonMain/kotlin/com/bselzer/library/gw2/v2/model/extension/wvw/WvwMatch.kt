package com.bselzer.library.gw2.v2.model.extension.wvw

import com.bselzer.library.gw2.v2.model.enumeration.extension.wvw.owner
import com.bselzer.library.gw2.v2.model.enumeration.wvw.ObjectiveOwner.*
import com.bselzer.library.gw2.v2.model.wvw.match.WvwMap
import com.bselzer.library.gw2.v2.model.wvw.match.WvwMapObjective
import com.bselzer.library.gw2.v2.model.wvw.match.WvwMatch
import com.bselzer.library.gw2.v2.model.wvw.objective.WvwObjective

/**
 * @return the objective from the match endpoint that matches the objective from the objectives endpoint
 */
fun WvwMatch?.objective(objective: WvwObjective): WvwMapObjective? = this?.map(objective)?.objectives?.firstOrNull { match -> match.id == objective.id }

/**
 * @return the map associated with the [objective]
 */
fun WvwMatch.map(objective: WvwObjective): WvwMap? = this.maps.firstOrNull { map -> map.id == objective.mapId }

/**
 * @return all the world ids linked together that are associated with the [WvwMapObjective.owner]
 */
fun WvwMatch.linkedWorlds(objective: WvwObjective): Collection<Int> = when (objective(objective)?.owner()) {
    RED -> allWorlds.red
    BLUE -> allWorlds.blue
    GREEN -> allWorlds.green
    else -> emptyList()
}

/**
 * @return the main world id associated with the [WvwMapObjective.owner]
 */
fun WvwMatch.mainWorld(objective: WvwObjective): Int? = when (objective(objective)?.owner()) {
    RED -> worlds.red
    BLUE -> worlds.blue
    GREEN -> worlds.green
    else -> null
}