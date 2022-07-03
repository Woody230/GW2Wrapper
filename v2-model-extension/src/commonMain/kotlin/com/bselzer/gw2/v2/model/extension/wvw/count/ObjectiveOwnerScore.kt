package com.bselzer.gw2.v2.model.extension.wvw.count

import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner

interface ObjectiveOwnerScore {
    /**
     * The score for each [WvwObjectiveOwner]
     */
    val scores: Map<WvwObjectiveOwner, Int>
}