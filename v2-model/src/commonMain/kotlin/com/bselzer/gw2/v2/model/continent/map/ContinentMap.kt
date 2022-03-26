package com.bselzer.gw2.v2.model.continent.map

import com.bselzer.gw2.v2.model.character.CharacterLevel
import com.bselzer.gw2.v2.model.continent.floor.FloorId
import com.bselzer.gw2.v2.model.continent.map.adventure.Adventure
import com.bselzer.gw2.v2.model.continent.map.challenge.HeroChallenge
import com.bselzer.gw2.v2.model.continent.map.heart.RenownHeart
import com.bselzer.gw2.v2.model.continent.map.heart.RenownHeartId
import com.bselzer.gw2.v2.model.continent.map.mastery.MasteryPoint
import com.bselzer.gw2.v2.model.continent.map.pointofinterest.PointOfInterest
import com.bselzer.gw2.v2.model.continent.map.pointofinterest.PointOfInterestId
import com.bselzer.gw2.v2.model.continent.map.sector.Sector
import com.bselzer.gw2.v2.model.continent.map.sector.SectorId
import com.bselzer.gw2.v2.model.map.MapId
import com.bselzer.ktx.geometry.dimension.bi.polygon.Digon
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContinentMap(
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
    val mapRectangle: Digon = Digon(),

    /**
     * The continent dimensions.
     *
     * The first sublist contains the top-left coordinates.
     *
     * The second sublist contains the bottom-right coordinates.
     */
    @SerialName("continent_rect")
    val continentRectangle: Digon = Digon(),

    /**
     * A map of the point of interest id to the point of interest object, which include landmarks, waypoints, and vistas.
     */
    @SerialName("points_of_interest")
    val pointsOfInterest: Map<PointOfInterestId, PointOfInterest> = emptyMap(),

    /**
     * A map of the renown heart id to the renown heart object.
     */
    @SerialName("tasks")
    val renownHearts: Map<RenownHeartId, RenownHeart> = emptyMap(),

    /**
     * The hero challenges. Previously known as skill challenges.
     */
    @SerialName("skill_challenges")
    val heroChallenges: List<HeroChallenge> = emptyList(),

    /**
     * A map of the sector id to the sector object.
     */
    @SerialName("sectors")
    val sectors: Map<SectorId, Sector> = emptyMap(),

    @SerialName("adventures")
    val adventures: List<Adventure> = emptyList(),

    @SerialName("mastery_points")
    val masteryPoints: List<MasteryPoint> = emptyList()
) : Identifiable<Int>