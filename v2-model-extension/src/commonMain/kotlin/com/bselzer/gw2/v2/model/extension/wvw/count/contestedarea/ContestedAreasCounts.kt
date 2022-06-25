package com.bselzer.gw2.v2.model.extension.wvw.count.contestedarea

import com.bselzer.gw2.v2.model.wvw.map.WvwMapObjective
import com.bselzer.gw2.v2.model.wvw.objective.WvwObjective

abstract class ContestedAreasCounts(
    val counts: List<ContestedAreasCount>
) : List<ContestedAreasCount> by counts {
    /**
     * The first objective found in the [counts].
     *
     * This sample can be used to cherry pick common objective information by mapping it to a [WvwObjective].
     */
    val sample: WvwMapObjective? = counts.firstNotNullOfOrNull { count -> count.firstOrNull() }
}