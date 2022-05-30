package com.bselzer.gw2.v2.model.map

import com.bselzer.gw2.v2.model.character.CharacterLevel
import com.bselzer.gw2.v2.model.continent.ContinentId
import com.bselzer.gw2.v2.model.continent.floor.FloorId
import com.bselzer.gw2.v2.model.continent.region.RegionId
import com.bselzer.gw2.v2.model.enumeration.wrapper.MapType
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Map(
    @SerialName("id")
    override val id: MapId = MapId(),

    @SerialName("name")
    val name: String = "",

    /**
     * The minimum recommended level of this map.
     */
    @SerialName("min_level")
    val minLevel: CharacterLevel = CharacterLevel(),

    /**
     * The maximum recommended level of this map.
     */
    @SerialName("max_level")
    val maxLevel: CharacterLevel = CharacterLevel(),

    /**
     * The id of the default floor.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    @SerialName("default_floor")
    val defaultFloorId: FloorId = FloorId(),

    /**
     * The map dimensions.
     *
     * The first sublist contains the bottom-left coordinates.
     *
     * The second sublist contains the top-right coordinates.
     */
    @SerialName("map_rect")
    val mapRectangle: List<List<Double>> = emptyList(),

    /**
     * The continent dimensions.
     *
     * The first sublist contains the top-left coordinates.
     *
     * The second sublist contains are the bottom-right coordinates.
     */
    @SerialName("continent_rect")
    val continentRectangle: List<List<Double>> = emptyList(),

    @SerialName("type")
    val type: MapType = MapType(),

    /**
     * The ids of the floors.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    @SerialName("floors")
    val floorIds: List<FloorId> = emptyList(),

    /**
     * The id of the region.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    @SerialName("region_id")
    val regionId: RegionId = RegionId(),

    /**
     * The name of the region.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    @SerialName("region_name")
    val regionName: String = "",

    /**
     * The id of the continent.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    @SerialName("continent_id")
    val continentId: ContinentId = ContinentId(),

    /**
     * The name of the continent.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    @SerialName("continent_name")
    val continentName: String = ""
) : Identifiable<MapId, Int>