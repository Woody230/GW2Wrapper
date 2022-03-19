package com.bselzer.gw2.v2.model.extension.wvw

import com.bselzer.gw2.v2.model.wvw.match.WvwMap
import com.bselzer.gw2.v2.model.wvw.objective.WvwObjective
import kotlin.jvm.JvmInline

/**
 * The full id of a [WvwObjective].
 */
@JvmInline
value class WvwObjectiveId(val value: String) {
    /**
     * The id of the [WvwMap] the objective is on.
     */
    val mapId: Int
        get() = value.split("-").getOrNull(0)?.toIntOrNull() ?: -1

    /**
     * The id specific to the objective.
     */
    val objectiveId: Int
        get() = value.split("-").getOrNull(1)?.toIntOrNull() ?: -1
}