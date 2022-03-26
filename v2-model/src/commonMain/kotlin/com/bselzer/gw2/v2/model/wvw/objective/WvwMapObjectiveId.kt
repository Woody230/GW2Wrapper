package com.bselzer.gw2.v2.model.wvw.objective

import com.bselzer.gw2.v2.model.map.MapId
import com.bselzer.gw2.v2.model.wvw.map.WvwMap
import com.bselzer.ktx.value.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * The full id of a [WvwObjective] which includes the id of the [WvwMap].
 */
@Serializable
@JvmInline
value class WvwMapObjectiveId(override val value: String = "0-0") : StringIdentifier {
    constructor(mapId: MapId, objectiveId: WvwObjectiveId) : this("$mapId-$objectiveId")

    /**
     * The id of the [WvwMap] that the [WvwObjective] is on.
     */
    val mapId: MapId
        get() = MapId(value.split("-").getOrNull(0)?.toIntOrNull() ?: 0)

    /**
     * The id specific to the [WvwObjective].
     */
    val objectiveId: WvwObjectiveId
        get() = WvwObjectiveId(value.split("-").getOrNull(1)?.toIntOrNull() ?: 0)

    override val isDefault: Boolean
        get() = mapId.isDefault || objectiveId.isDefault

    override fun toString(): String = value
}