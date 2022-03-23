package com.bselzer.gw2.v2.model.enumeration.extension

import com.bselzer.gw2.v2.model.enumeration.WorldLanguage
import com.bselzer.gw2.v2.model.enumeration.WorldRegion
import com.bselzer.gw2.v2.model.serialization.Modules
import com.bselzer.gw2.v2.model.world.World
import com.bselzer.gw2.v2.model.world.WorldId
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.serializer

/**
 * The region associated with the [World.id].
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">the wiki</a>
 */
fun WorldId.region(): WorldRegion? = try {
    Modules.JSON.decodeFromJsonElement(serializer(), JsonPrimitive(regionId))
} catch (ex: SerializationException) {
    null
}

/**
 * The language associated with the [World.id].
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">the wiki</a>
 */
fun WorldId.language(): WorldLanguage? = try {
    Modules.JSON.decodeFromJsonElement(serializer(), JsonPrimitive(languageId))
} catch (ex: SerializationException) {
    null
}