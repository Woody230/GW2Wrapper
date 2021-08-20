package com.bselzer.library.gw2.v2.model.extension.common.chatlink

import com.bselzer.library.kotlin.extension.function.common.collection.toByteArray
import com.bselzer.library.kotlin.extension.function.common.collection.toInt

/**
 * A link to a world vs. world objective.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/objectives">the wiki</a>
 */
class WvwObjectiveLink(

    /**
     * The id of the objective.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/objectives">the wiki</a>
     */
    var objectiveId: Int = 0,

    /**
     * The id of the map.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/objectives">the wiki</a>
     */
    var mapId: Int = 0,
) : ChatLink()
{
    /**
     * The map id and objective id combined to match the objective id found in the objectives endpoint.
     * The id is in the form of "{{MapId}}-{{ObjectiveId}}".
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/objectives">the wiki</a>
     */
    val mapObjectiveId: String
        get() = "$mapId-$objectiveId"

    constructor(mapObjectiveId: String) : this()
    {
        val split = mapObjectiveId.split('-')
        if (split.size != 2)
        {
            throw IllegalArgumentException("Unable to parse the map-objective id from $mapObjectiveId. The id must be in the form of \"{{MapId}}-{{ObjectiveId}}\".")
        }

        objectiveId = split[1].toInt()
        mapId = split[0].toInt()
    }

    override val header: Byte = 12

    override fun getData(): ByteArray = objectiveId.toByteArray(take = 3, capacity = 4) + mapId.toByteArray(take = 3, capacity = 4)

    override fun decode(bytes: ByteArray)
    {
        if (bytes.size != 8)
        {
            throw IllegalArgumentException("Unable to decode ${this::class.simpleName}: exactly 8 data bytes are required for the objective id and map id")
        }

        objectiveId = bytes.copyOfRange(0, 4).toInt()
        mapId = bytes.copyOfRange(4, 8).toInt()
    }
}