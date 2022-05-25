package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.model.Language
import com.bselzer.gw2.v2.model.continent.Continent
import com.bselzer.gw2.v2.model.continent.ContinentId
import com.bselzer.gw2.v2.model.continent.floor.Floor
import com.bselzer.gw2.v2.model.continent.floor.FloorId
import com.bselzer.gw2.v2.model.continent.map.ContinentMap
import com.bselzer.gw2.v2.model.continent.map.heart.RenownHeart
import com.bselzer.gw2.v2.model.continent.map.heart.RenownHeartId
import com.bselzer.gw2.v2.model.continent.map.pointofinterest.PointOfInterest
import com.bselzer.gw2.v2.model.continent.map.pointofinterest.PointOfInterestId
import com.bselzer.gw2.v2.model.continent.map.sector.Sector
import com.bselzer.gw2.v2.model.continent.map.sector.SectorId
import com.bselzer.gw2.v2.model.continent.region.Region
import com.bselzer.gw2.v2.model.continent.region.RegionId
import com.bselzer.gw2.v2.model.map.MapId
import io.ktor.client.*

/**
 * The continent client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
 */
class ContinentClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val CONTINENTS = "continents"
        const val FLOORS = "floors"
        const val REGIONS = "regions"
        const val MAPS = "maps"
        const val SECTORS = "sectors"
        const val POINT_OF_INTERESTS = "pois"
        const val TASKS = "tasks"
    }

    /**
     * @return the ids of the available continents
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun ids(): List<ContinentId> = getIds(path = CONTINENTS)

    /**
     * @return the continent associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun continent(id: ContinentId, language: Language? = null): Continent = getSingleById(id, CONTINENTS, instance = { Continent(id = it) }) {
        language(language)
    }

    /**
     * @return the continents associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun continents(ids: Collection<ContinentId>, language: Language? = null): List<Continent> = chunkedIds(ids, CONTINENTS, instance = { Continent(id = it) }) {
        language(language)
    }

    /**
     * @return all the continents
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun continents(language: Language? = null): List<Continent> = allIds(CONTINENTS) {
        language(language)
    }

    /**
     * @return the ids of the available floors in the continent with [continentId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun floorIds(continentId: ContinentId): List<FloorId> = getIds(path = "${CONTINENTS}/${continentId}/${FLOORS}")

    /**
     * @return the floor associated with the [floorId] in the continent with the [continentId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun floor(continentId: ContinentId, floorId: FloorId, language: Language? = null): Floor =
        getSingleById(floorId, "${CONTINENTS}/${continentId}/${FLOORS}", instance = { Floor(id = it) }) {
            language(language)
        }

    /**
     * @return the floors associated with the [floorIds] in the continent with the [continentId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun floors(continentId: ContinentId, floorIds: Collection<FloorId>, language: Language? = null): List<Floor> =
        chunkedIds(floorIds, "${CONTINENTS}/${continentId}/${FLOORS}", instance = { Floor(id = it) }) {
            language(language)
        }

    /**
     * @return all the floors in the continent with the [continentId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun floors(continentId: ContinentId, language: Language? = null): List<Floor> = allIds("${CONTINENTS}/${continentId}/${FLOORS}") {
        language(language)
    }

    /**
     * @return the ids of the available regions in the continent with [continentId] and floor with [floorId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun regionIds(continentId: ContinentId, floorId: FloorId): List<RegionId> =
        getIds(path = "${CONTINENTS}/${continentId}/${FLOORS}/${floorId}/${REGIONS}")

    /**
     * @return the region associated with the [regionId] in the continent with [continentId] and floor with [floorId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun region(continentId: ContinentId, floorId: FloorId, regionId: RegionId, language: Language? = null): Region =
        getSingleById(regionId, "${CONTINENTS}/${continentId}/${FLOORS}/${floorId}/${REGIONS}", instance = { Region(id = it) }) {
            language(language)
        }

    /**
     * @return the regions associated with the [regionIds] in the continent with [continentId] and floor with [floorId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun regions(continentId: ContinentId, floorId: FloorId, regionIds: Collection<RegionId>, language: Language? = null): List<Region> =
        chunkedIds(regionIds, "${CONTINENTS}/${continentId}/${FLOORS}/${floorId}/${REGIONS}", instance = { Region(id = it) }) {
            language(language)
        }

    /**
     * @return all the regions in the continent with [continentId] and floor with [floorId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun regions(continentId: ContinentId, floorId: FloorId, language: Language? = null): List<Region> =
        allIds("${CONTINENTS}/${continentId}/${FLOORS}/${floorId}/${REGIONS}") {
            language(language)
        }

    /**
     * @return the ids of the available maps in the continent with [continentId], floor with [floorId], and region with [regionId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun mapIds(continentId: ContinentId, floorId: FloorId, regionId: RegionId): List<MapId> =
        getIds(path = "${CONTINENTS}/${continentId}/${FLOORS}/${floorId}/${REGIONS}/${regionId}/${MAPS}")

    /**
     * @return the map associated with the [mapId] in the continent with [continentId], floor with [floorId], and region with [regionId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun map(continentId: ContinentId, floorId: FloorId, regionId: RegionId, mapId: MapId, language: Language? = null): ContinentMap =
        getSingleById(mapId, "${CONTINENTS}/${continentId}/${FLOORS}/${floorId}/${REGIONS}/${regionId}/${MAPS}", instance = { ContinentMap(id = it) }) {
            language(language)
        }

    /**
     * @return the maps associated with the [mapIds] in the continent with [continentId], floor with [floorId], and region with [regionId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun maps(continentId: ContinentId, floorId: FloorId, regionId: RegionId, mapIds: Collection<MapId>, language: Language? = null): List<ContinentMap> =
        chunkedIds(mapIds, "${CONTINENTS}/${continentId}/${FLOORS}/${floorId}/${REGIONS}/${regionId}/${MAPS}", instance = { ContinentMap(id = it) }) {
            language(language)
        }

    /**
     * @return all the maps in the continent with [continentId], floor with [floorId], and region with [regionId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun maps(continentId: ContinentId, floorId: FloorId, regionId: RegionId, language: Language? = null): List<ContinentMap> =
        allIds("${CONTINENTS}/${continentId}/${FLOORS}/${floorId}/${REGIONS}/${regionId}/${MAPS}") {
            language(language)
        }

    /**
     * @return the ids of the available sectors in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun sectorIds(continentId: ContinentId, floorId: FloorId, regionId: RegionId, mapId: MapId): List<SectorId> =
        getIds(path = "${CONTINENTS}/${continentId}/${FLOORS}/${floorId}/${REGIONS}/${regionId}/${MAPS}/${mapId}/${SECTORS}")

    /**
     * @return the sector associated with the [sectorId] in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun sector(continentId: ContinentId, floorId: FloorId, regionId: RegionId, mapId: MapId, sectorId: SectorId, language: Language? = null): Sector = getSingleById(
        sectorId,
        "${CONTINENTS}/${continentId}/${FLOORS}/${floorId}/${REGIONS}/${regionId}/${MAPS}/${mapId}/${SECTORS}",
        instance = { Sector(id = it) }
    ) {
        language(language)
    }

    /**
     * @return the sectors associated with the [sectorIds] in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun sectors(
        continentId: ContinentId,
        floorId: FloorId,
        regionId: RegionId,
        mapId: MapId,
        sectorIds: Collection<SectorId>,
        language: Language? = null
    ): List<Sector> = chunkedIds(
        sectorIds,
        "${CONTINENTS}/${continentId}/${FLOORS}/${floorId}/${REGIONS}/${regionId}/${MAPS}/${mapId}/${SECTORS}",
        instance = { Sector(id = it) }
    ) {
        language(language)
    }

    /**
     * @return all the sectors in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun sectors(continentId: ContinentId, floorId: FloorId, regionId: RegionId, mapId: MapId, language: Language? = null): List<Sector> =
        allIds("${CONTINENTS}/${continentId}/${FLOORS}/${floorId}/${REGIONS}/${regionId}/${MAPS}/${mapId}/${SECTORS}") {
            language(language)
        }

    /**
     * @return the ids of the available point of interests in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun pointOfInterestIds(continentId: ContinentId, floorId: FloorId, regionId: RegionId, mapId: MapId): List<PointOfInterestId> =
        getIds(path = "${CONTINENTS}/${continentId}/${FLOORS}/${floorId}/${REGIONS}/${regionId}/${MAPS}/${mapId}/${POINT_OF_INTERESTS}")

    /**
     * @return the point of interest associated with the [pointOfInterestId] in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun pointOfInterest(
        continentId: ContinentId,
        floorId: FloorId,
        regionId: RegionId,
        mapId: MapId,
        pointOfInterestId: PointOfInterestId,
        language: Language? = null
    ): PointOfInterest = getSingleById(
        pointOfInterestId,
        "${CONTINENTS}/${continentId}/${FLOORS}/${floorId}/${REGIONS}/${regionId}/${MAPS}/${mapId}/${POINT_OF_INTERESTS}",
        instance = { PointOfInterest(id = it) }
    ) {
        language(language)
    }

    /**
     * @return the point of interests associated with the [pointOfInterestIds] in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun pointOfInterests(
        continentId: ContinentId,
        floorId: FloorId,
        regionId: RegionId,
        mapId: MapId,
        pointOfInterestIds: Collection<PointOfInterestId>,
        language: Language? = null
    ): List<PointOfInterest> = chunkedIds(
        pointOfInterestIds,
        "${CONTINENTS}/${continentId}/${FLOORS}/${floorId}/${REGIONS}/${regionId}/${MAPS}/${mapId}/${POINT_OF_INTERESTS}",
        instance = { PointOfInterest(id = it) }
    ) {
        language(language)
    }

    /**
     * @return all the point of interests in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun pointOfInterests(continentId: ContinentId, floorId: FloorId, regionId: RegionId, mapId: MapId, language: Language? = null): List<PointOfInterest> =
        allIds("${CONTINENTS}/${continentId}/${FLOORS}/${floorId}/${REGIONS}/${regionId}/${MAPS}/${mapId}/${POINT_OF_INTERESTS}") {
            language(language)
        }

    /**
     * @return the ids of the available renown hearts in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun renownHeartIds(continentId: ContinentId, floorId: FloorId, regionId: RegionId, mapId: MapId): List<RenownHeartId> =
        getIds(path = "${CONTINENTS}/${continentId}/${FLOORS}/${floorId}/${REGIONS}/${regionId}/${MAPS}/${mapId}/${TASKS}")

    /**
     * @return the renown hearts associated with the [renownHeartId] in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun renownHeart(
        continentId: ContinentId,
        floorId: FloorId,
        regionId: RenownHeartId,
        mapId: MapId,
        renownHeartId: RenownHeartId,
        language: Language? = null
    ): RenownHeart =
        getSingleById(
            renownHeartId,
            "${CONTINENTS}/${continentId}/${FLOORS}/${floorId}/${REGIONS}/${regionId}/${MAPS}/${mapId}/${TASKS}",
            instance = { RenownHeart(id = it) }
        ) {
            language(language)
        }

    /**
     * @return the renown hearts associated with the [renownHeartIds] in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun renownHearts(
        continentId: ContinentId,
        floorId: FloorId,
        regionId: RenownHeartId,
        mapId: MapId,
        renownHeartIds: Collection<RenownHeartId>,
        language: Language? = null
    ): List<RenownHeart> =
        chunkedIds(
            renownHeartIds,
            "${CONTINENTS}/${continentId}/${FLOORS}/${floorId}/${REGIONS}/${regionId}/${MAPS}/${mapId}/${TASKS}",
            instance = { RenownHeart(id = it) }
        ) {
            language(language)
        }

    /**
     * @return all the renown hearts in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun renownHearts(continentId: ContinentId, floorId: FloorId, regionId: RenownHeartId, mapId: MapId, language: Language? = null): List<RenownHeart> =
        allIds("${CONTINENTS}/${continentId}/${FLOORS}/${floorId}/${REGIONS}/${regionId}/${MAPS}/${mapId}/${TASKS}") {
            language(language)
        }
}