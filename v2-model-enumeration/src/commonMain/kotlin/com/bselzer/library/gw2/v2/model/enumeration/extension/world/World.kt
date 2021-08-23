package com.bselzer.library.gw2.v2.model.enumeration.extension.world

import com.bselzer.library.gw2.v2.model.enumeration.world.WorldLanguage
import com.bselzer.library.gw2.v2.model.enumeration.world.WorldName
import com.bselzer.library.gw2.v2.model.enumeration.world.WorldPopulationLevel
import com.bselzer.library.gw2.v2.model.enumeration.world.WorldRegion
import com.bselzer.library.gw2.v2.model.world.World
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.serializer

private val json: Json = Json {

}

/**
 * The [World.name] as a [WorldName]
 */
fun World.name(): WorldName? = name.enumValueOrNull<WorldName>()

/**
 * The [World.population] as a [WorldPopulationLevel]
 */
fun World.population(): WorldPopulationLevel? = population.enumValueOrNull<WorldPopulationLevel>()

/**
 * The region associated with the [World.id].
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">the wiki</a>
 */
fun World.region(): WorldRegion?
{
    return try
    {
        val regionId = id.toString().getOrNull(0)?.toString() ?: return null
        Json { coerceInputValues = true }.decodeFromJsonElement(serializer(), JsonPrimitive(regionId))
    } catch (ex: SerializationException)
    {
        null
    }
}

/**
 * The language associated with the [World.id].
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">the wiki</a>
 */
fun World.language(): WorldLanguage?
{
    return try
    {
        val languageId = id.toString().getOrNull(1)?.toString() ?: return null
        Json.decodeFromJsonElement(serializer(), JsonPrimitive(languageId))
    } catch (ex: SerializationException)
    {
        null
    }
}