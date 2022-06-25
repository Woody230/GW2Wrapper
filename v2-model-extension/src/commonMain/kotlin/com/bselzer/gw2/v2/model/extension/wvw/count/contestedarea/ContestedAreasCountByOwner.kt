package com.bselzer.gw2.v2.model.extension.wvw.count.contestedarea

import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveType

class ContestedAreasCountByOwner internal constructor(
    /**
     * The owner of the contested area and the objectives being counted.
     */
    val owner: WvwObjectiveOwner,

    /**
     * The counts for objectives owned by the [owner] for a range of [WvwObjectiveType]s.
     */
    counts: List<ContestedAreasCount>
) : ContestedAreasCounts(counts)