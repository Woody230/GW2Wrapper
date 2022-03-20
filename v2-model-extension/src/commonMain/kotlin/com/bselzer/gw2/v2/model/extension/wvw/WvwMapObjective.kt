package com.bselzer.gw2.v2.model.extension.wvw

import com.bselzer.gw2.v2.model.wvw.map.WvwMapObjective
import com.bselzer.gw2.v2.model.wvw.objective.WvwMapObjectiveId

/**
 * The id of the objective wrapped by a [WvwMapObjectiveId].
 */
fun WvwMapObjective.id(): WvwMapObjectiveId = WvwMapObjectiveId(id)