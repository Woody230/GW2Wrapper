package com.bselzer.gw2.v2.model.extension.wvw.count.contestedarea

import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveType
import com.bselzer.gw2.v2.model.wvw.map.WvwMapObjective

class ContestedAreas internal constructor(objectives: Collection<WvwMapObjective>) {
    /**
     * A [ContestedAreasGrid] where the count prioritizes the [WvwObjectiveOwner].
     */
    val byOwner = ContestedAreasByOwner(objectives)

    /**
     * A [ContestedAreasGrid] where the count prioritizes the [WvwObjectiveType].
     */
    val byType = ContestedAreasByType(objectives)
}