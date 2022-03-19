package com.bselzer.gw2.v2.model.extension.wvw

import com.bselzer.gw2.v2.model.wvw.match.WvwMapObjective

/**
 * The id of the objective wrapped by a [WvwObjectiveId].
 */
fun WvwMapObjective.id(): WvwObjectiveId = WvwObjectiveId(id)