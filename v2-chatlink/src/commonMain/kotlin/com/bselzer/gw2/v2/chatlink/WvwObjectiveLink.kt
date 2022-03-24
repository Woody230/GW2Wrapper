package com.bselzer.gw2.v2.chatlink

import com.bselzer.gw2.v2.model.map.MapId
import com.bselzer.gw2.v2.model.wvw.objective.WvwMapObjectiveId
import com.bselzer.gw2.v2.model.wvw.objective.WvwObjectiveId
import com.bselzer.ktx.function.collection.removeFirst
import com.bselzer.ktx.function.collection.toByteArray
import com.bselzer.ktx.function.collection.toInt

/**
 * A link to a world vs. world objective.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/objectives">the wiki</a>
 */
class WvwObjectiveLink(var id: WvwMapObjectiveId = WvwMapObjectiveId()) : ChatLink() {
    override val header: Byte = 12

    override fun getData(): ByteArray = id.objectiveId.value.toByteArray(take = 3, capacity = 4) + id.mapId.value.toByteArray(take = 3, capacity = 4)

    override fun decode(bytes: ArrayDeque<Byte>) {
        if (bytes.size != 8) {
            throw IllegalArgumentException("Unable to decode ${this::class.simpleName}: exactly 8 data bytes are required for the objective id and map id")
        }

        val objectiveId = bytes.removeFirst(take = 4).toInt()
        val mapId = bytes.removeFirst(take = 4).toInt()
        id = WvwMapObjectiveId(MapId(mapId), WvwObjectiveId(objectiveId))
    }
}