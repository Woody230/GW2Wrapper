package com.bselzer.gw2.v2.model.world

import com.bselzer.ktx.value.identifier.IntIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class WorldId(override val value: Int = 0) : IntIdentifier {
    /**
     * The id of the region associated with the [World.id].
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">the wiki</a>
     */
    val regionId: Int
        get() = value.toString().getOrNull(0)?.digitToIntOrNull() ?: 0

    /**
     * The id of the language associated with the [World.id].
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">the wiki</a>
     */
    val languageId: Int
        get() = value.toString().getOrNull(1)?.digitToIntOrNull() ?: 0

    override fun toString(): String = value.toString()
}