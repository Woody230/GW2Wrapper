package com.bselzer.library.gw2.v2.model.extension.wvw

import com.bselzer.library.gw2.v2.model.wvw.match.WvwMapObjective
import com.bselzer.library.gw2.v2.model.wvw.match.WvwMatch
import com.bselzer.library.gw2.v2.model.wvw.objective.WvwObjective

/**
 * @return the objective from the match endpoint that matches the objective from the objectives endpoint
 */
fun WvwMatch?.objective(objective: WvwObjective): WvwMapObjective? = this?.maps?.firstOrNull { map -> map.id == objective.mapId }?.objectives?.firstOrNull { match -> match.id == objective.id }