package com.bselzer.gw2.v2.model.extension.wvw

import com.bselzer.gw2.v2.model.wvw.map.WvwMap

/**
 * @return the counts for each objective owner
 */
fun WvwMap.objectiveOwnerCount() = WvwMapObjectiveOwnerCount(this)