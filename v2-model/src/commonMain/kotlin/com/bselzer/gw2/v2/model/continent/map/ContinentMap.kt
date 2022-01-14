package com.bselzer.gw2.v2.model.continent.map

import com.bselzer.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContinentMap(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("name")
    val name: String = "",

    /**
     * The minimum recommended level of this map.
     */
    @SerialName("min_level")
    val minLevel: Int = 0,

    /**
     * The maximum recommended level of this map.
     */
    @SerialName("max_level")
    val maxLevel: Int = 0,

    /**
     * The id of the default floor.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    @SerialName("default_floor")
    val defaultFloorId: Int = 0,

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
     * The second sublist contains the bottom-right coordinates.
     */
    @SerialName("continent_rect")
    val continentRectangle: List<List<Double>> = emptyList(),

    /**
     * A map of the point of interest id to the point of interest object, which include landmarks, waypoints, and vistas.
     */
    @SerialName("points_of_interest")
    val pointsOfInterest: Map<Int, MapPointOfInterest> = emptyMap(),

    /**
     * A map of the renown heart id to the renown heart object.
     */
    @SerialName("tasks")
    val renownHearts: Map<Int, MapRenownHeart> = emptyMap(),

    /**
     * The hero challenges. Previously known as skill challenges.
     */
    @SerialName("skill_challenges")
    val heroChallenges: List<MapHeroChallenge> = emptyList(),

    /**
     * A map of the sector id to the sector object.
     */
    @SerialName("sectors")
    val sectors: Map<Int, MapSector> = emptyMap(),

    @SerialName("adventures")
    val adventures: List<MapAdventure> = emptyList(),

    @SerialName("mastery_points")
    val masteryPoints: List<MapMasteryPoint> = emptyList()
) : Identifiable<Int>