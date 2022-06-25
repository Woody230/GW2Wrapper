package com.bselzer.gw2.v2.model.extension.wvw.count.contestedarea

import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveType

class ContestedAreasCountByType(
    /**
     * The type of objective being counted.
     */
    val type: WvwObjectiveType,

    /**
     * The counts for objectives of [type] for a range of [WvwObjectiveOwner]s.
     */
    counts: List<ContestedAreasCount>
) : ContestedAreasCounts(counts)