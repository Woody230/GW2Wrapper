package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Continents
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.continent.Continent
import com.bselzer.library.gw2.v2.model.common.continent.ContinentFloor
import com.bselzer.library.gw2.v2.model.common.continent.ContinentRegion
import com.bselzer.library.gw2.v2.model.common.continent.map.ContinentMap
import com.bselzer.library.gw2.v2.model.common.continent.map.MapPointOfInterest
import com.bselzer.library.gw2.v2.model.common.continent.map.MapRenownHeart
import com.bselzer.library.gw2.v2.model.common.continent.map.MapSector
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The continent client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
 */
class ContinentClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available continents
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun ids(): List<Int> = httpClient.get(path = Continents.CONTINENTS)

    /**
     * @return the continent associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun continent(id: Int, language: String? = null): Continent = single(id, Continents.CONTINENTS) {
        language(language)
    }

    /**
     * @return the continents associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun continents(ids: Collection<Int>, language: String? = null): List<Continent> = chunkedIds(ids, Continents.CONTINENTS) {
        language(language)
    }

    /**
     * @return all the continents
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun continents(language: String? = null): List<Continent> = allIds(Continents.CONTINENTS) {
        language(language)
    }

    /**
     * @return the ids of the available floors in the continent with [continentId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun floorIds(continentId: Int): List<Int> = httpClient.get(path = "${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}")

    /**
     * @return the floor associated with the [floorId] in the continent with the [continentId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun floor(continentId: Int, floorId: Int, language: String? = null): ContinentFloor =
        single(floorId, "${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}") {
            language(language)
        }

    /**
     * @return the floors associated with the [floorIds] in the continent with the [continentId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun floors(continentId: Int, floorIds: Collection<Int>, language: String? = null): List<ContinentFloor> =
        chunkedIds(floorIds, "${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}") {
            language(language)
        }

    /**
     * @return all the floors in the continent with the [continentId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun floors(continentId: Int, language: String? = null): List<ContinentFloor> = allIds("${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}") {
        language(language)
    }

    /**
     * @return the ids of the available regions in the continent with [continentId] and floor with [floorId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun regionIds(continentId: Int, floorId: Int): List<Int> =
        httpClient.get(path = "${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}/${floorId}/${Continents.REGIONS}")

    /**
     * @return the region associated with the [regionId] in the continent with [continentId] and floor with [floorId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun region(continentId: Int, floorId: Int, regionId: Int, language: String? = null): ContinentRegion =
        single(regionId, "${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}/${floorId}/${Continents.REGIONS}") {
            language(language)
        }

    /**
     * @return the regions associated with the [regionIds] in the continent with [continentId] and floor with [floorId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun regions(continentId: Int, floorId: Int, regionIds: Collection<Int>, language: String? = null): List<ContinentRegion> =
        chunkedIds(regionIds, "${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}/${floorId}/${Continents.REGIONS}") {
            language(language)
        }

    /**
     * @return all the regions in the continent with [continentId] and floor with [floorId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun regions(continentId: Int, floorId: Int, language: String? = null): List<ContinentRegion> =
        allIds("${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}/${floorId}/${Continents.REGIONS}") {
            language(language)
        }

    /**
     * @return the ids of the available maps in the continent with [continentId], floor with [floorId], and region with [regionId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun mapIds(continentId: Int, floorId: Int, regionId: Int): List<Int> =
        httpClient.get(path = "${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}/${floorId}/${Continents.REGIONS}/${regionId}/${Continents.MAPS}")

    /**
     * @return the map associated with the [mapId] in the continent with [continentId], floor with [floorId], and region with [regionId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun map(continentId: Int, floorId: Int, regionId: Int, mapId: Int, language: String? = null): ContinentMap =
        single(mapId, "${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}/${floorId}/${Continents.REGIONS}/${regionId}/${Continents.MAPS}") {
            language(language)
        }

    /**
     * @return the maps associated with the [mapIds] in the continent with [continentId], floor with [floorId], and region with [regionId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun maps(continentId: Int, floorId: Int, regionId: Int, mapIds: Collection<Int>, language: String? = null): List<ContinentMap> =
        chunkedIds(mapIds, "${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}/${floorId}/${Continents.REGIONS}/${regionId}/${Continents.MAPS}") {
            language(language)
        }

    /**
     * @return all the maps in the continent with [continentId], floor with [floorId], and region with [regionId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun maps(continentId: Int, floorId: Int, regionId: Int, language: String? = null): List<ContinentMap> =
        allIds("${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}/${floorId}/${Continents.REGIONS}/${regionId}/${Continents.MAPS}") {
            language(language)
        }

    /**
     * @return the ids of the available sectors in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun sectorIds(continentId: Int, floorId: Int, regionId: Int, mapId: Int): List<Int> =
        httpClient.get(path = "${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}/${floorId}/${Continents.REGIONS}/${regionId}/${Continents.MAPS}/${mapId}/${Continents.SECTORS}")

    /**
     * @return the sector associated with the [sectorId] in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun sector(continentId: Int, floorId: Int, regionId: Int, mapId: Int, sectorId: Int, language: String? = null): MapSector = single(
        sectorId,
        "${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}/${floorId}/${Continents.REGIONS}/${regionId}/${Continents.MAPS}/${mapId}/${Continents.SECTORS}"
    ) {
        language(language)
    }

    /**
     * @return the sectors associated with the [sectorIds] in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun sectors(continentId: Int, floorId: Int, regionId: Int, mapId: Int, sectorIds: Collection<Int>, language: String? = null): List<MapSector> = chunkedIds(
        sectorIds,
        "${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}/${floorId}/${Continents.REGIONS}/${regionId}/${Continents.MAPS}/${mapId}/${Continents.SECTORS}"
    ) {
        language(language)
    }

    /**
     * @return all the sectors in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun sectors(continentId: Int, floorId: Int, regionId: Int, mapId: Int, language: String? = null): List<MapSector> =
        allIds("${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}/${floorId}/${Continents.REGIONS}/${regionId}/${Continents.MAPS}/${mapId}/${Continents.SECTORS}") {
            language(language)
        }

    /**
     * @return the ids of the available point of interests in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun pointOfInterestIds(continentId: Int, floorId: Int, regionId: Int, mapId: Int): List<Int> =
        httpClient.get(path = "${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}/${floorId}/${Continents.REGIONS}/${regionId}/${Continents.MAPS}/${mapId}/${Continents.POINT_OF_INTERESTS}")

    /**
     * @return the point of interest associated with the [pointOfInterestId] in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun pointOfInterest(
        continentId: Int,
        floorId: Int,
        regionId: Int,
        mapId: Int,
        pointOfInterestId: Int,
        language: String? = null
    ): List<MapPointOfInterest> = single(
        pointOfInterestId,
        "${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}/${floorId}/${Continents.REGIONS}/${regionId}/${Continents.MAPS}/${mapId}/${Continents.POINT_OF_INTERESTS}"
    ) {
        language(language)
    }

    /**
     * @return the point of interests associated with the [pointOfInterestIds] in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun pointOfInterests(
        continentId: Int,
        floorId: Int,
        regionId: Int,
        mapId: Int,
        pointOfInterestIds: Collection<Int>,
        language: String? = null
    ): List<MapPointOfInterest> = chunkedIds(
        pointOfInterestIds,
        "${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}/${floorId}/${Continents.REGIONS}/${regionId}/${Continents.MAPS}/${mapId}/${Continents.POINT_OF_INTERESTS}"
    ) {
        language(language)
    }

    /**
     * @return all the point of interests in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun pointOfInterests(continentId: Int, floorId: Int, regionId: Int, mapId: Int, language: String? = null): List<MapPointOfInterest> =
        allIds("${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}/${floorId}/${Continents.REGIONS}/${regionId}/${Continents.MAPS}/${mapId}/${Continents.POINT_OF_INTERESTS}") {
            language(language)
        }

    /**
     * @return the ids of the available renown hearts in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun renownHeartIds(continentId: Int, floorId: Int, regionId: Int, mapId: Int): List<Int> =
        httpClient.get(path = "${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}/${floorId}/${Continents.REGIONS}/${regionId}/${Continents.MAPS}/${mapId}/${Continents.TASKS}")

    /**
     * @return the renown hearts associated with the [renownHeartId] in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun renownHeart(continentId: Int, floorId: Int, regionId: Int, mapId: Int, renownHeartId: Int, language: String? = null): MapRenownHeart =
        single(
            renownHeartId,
            "${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}/${floorId}/${Continents.REGIONS}/${regionId}/${Continents.MAPS}/${mapId}/${Continents.TASKS}"
        ) {
            language(language)
        }

    /**
     * @return the renown hearts associated with the [renownHeartIds] in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun renownHearts(continentId: Int, floorId: Int, regionId: Int, mapId: Int, renownHeartIds: Collection<Int>, language: String? = null): List<MapRenownHeart> =
        chunkedIds(
            renownHeartIds,
            "${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}/${floorId}/${Continents.REGIONS}/${regionId}/${Continents.MAPS}/${mapId}/${Continents.TASKS}"
        ) {
            language(language)
        }

    /**
     * @return all the renown hearts in the continent with [continentId], floor with [floorId], region with [regionId], and map with [mapId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    suspend fun renownHearts(continentId: Int, floorId: Int, regionId: Int, mapId: Int, language: String? = null): List<MapRenownHeart> =
        allIds("${Continents.CONTINENTS}/${continentId}/${Continents.FLOORS}/${floorId}/${Continents.REGIONS}/${regionId}/${Continents.MAPS}/${mapId}/${Continents.TASKS}") {
            language(language)
        }
}