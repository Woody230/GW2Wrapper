package com.bselzer.gw2.v2.cache.instance

import com.bselzer.gw2.v2.client.client.Gw2Client
import com.bselzer.gw2.v2.model.continent.Continent
import com.bselzer.gw2.v2.model.continent.ContinentId
import com.bselzer.gw2.v2.model.continent.floor.Floor
import com.bselzer.gw2.v2.model.continent.floor.FloorId
import com.bselzer.gw2.v2.model.continent.map.ContinentMap
import com.bselzer.gw2.v2.model.continent.region.Region
import com.bselzer.gw2.v2.model.continent.region.RegionId
import com.bselzer.gw2.v2.model.map.Map
import com.bselzer.gw2.v2.model.map.MapId
import com.bselzer.ktx.kodein.db.cache.Cache
import com.bselzer.ktx.kodein.db.operation.clear
import com.bselzer.ktx.kodein.db.operation.getById
import com.bselzer.ktx.kodein.db.transaction.Transaction

/**
 * Represents a cache for models related to [Continent].
 */
class ContinentCache(private val client: Gw2Client) : Cache {
    /**
     * Puts the map with the given [id] and its associated continent and default floor.
     *
     * @param id the id of the map
     */
    suspend fun Transaction.putMap(id: MapId): Unit {
        val map = getMap(id)

        // Set up or ensure the Continent and ContinentFloor exist.
        // ContinentRegion and ContinentMap are descendants of ContinentFloor so they do not need to be set up.
        getContinent(map.continentId)
        getContinentFloor(map.continentId, map.defaultFloorId)
    }

    /**
     * Gets the map with the given [id].
     *
     * If there is no map in the database, then the api is called.
     *
     * @param id the id of the map
     * @return the map
     */
    suspend fun Transaction.getMap(id: MapId): Map {
        return getById(id, { client.map.map(id) })
    }

    /**
     * Gets the continent associated with the map.
     *
     * If there is no continent in the database, then the api is called.
     *
     * @param map the map
     * @return the continent
     */
    suspend fun Transaction.getContinent(map: Map): Continent = getContinent(map.continentId)

    /**
     * Gets the default floor associated with the map.
     *
     * If there is no floor in the database, then the api is called.
     *
     * @param map the map
     * @return the default floor
     */
    suspend fun Transaction.getContinentFloor(map: Map): Floor = getContinentFloor(map.continentId, map.defaultFloorId)

    /**
     * Gets the region from the default floor associated with the map.
     *
     * @param map the map
     * @return the region from the default floor
     */
    suspend fun Transaction.getContinentRegion(map: Map): Region? = getContinentRegion(map.continentId, map.defaultFloorId, map.regionId)

    /**
     * Gets the map from the continents endpoint associated with the map from the maps endpoint.
     *
     * @param map the map
     * @return the continent map
     */
    suspend fun Transaction.getContinentMap(map: Map): ContinentMap? = getContinentMap(map.continentId, map.defaultFloorId, map.regionId, map.id)

    /**
     * Gets the continent with the given [id].
     *
     * @param id the id
     * @return the continent
     */
    suspend fun Transaction.getContinent(id: ContinentId): Continent {
        return getById(id, { client.continent.continent(id) })
    }

    /**
     * Gets the floor with the given [floorId] from the continent with the given [continentId].
     *
     * @param continentId the continent id
     * @param floorId the floor id
     * @return the floor of the continent
     */
    suspend fun Transaction.getContinentFloor(continentId: ContinentId, floorId: FloorId): Floor {
        return getById(floorId, { client.continent.floor(continentId, floorId) })
    }

    /**
     * Gets the region with the given [regionId] from the floor in the continent with the [floorId] and [continentId] respectively.
     *
     * @param continentId the continent id
     * @param floorId the floor id
     * @param regionId the region id
     * @return the region on the floor of the continent
     */
    suspend fun Transaction.getContinentRegion(continentId: ContinentId, floorId: FloorId, regionId: RegionId): Region? {
        val floor = getContinentFloor(continentId, floorId)
        return floor.regions[regionId]
    }

    /**
     * Gets the map with the given [mapId] from the region on the floor in the continent with the [regionId], [floorId], and [continentId] respectively.
     *
     * @param continentId the continent id
     * @param floorId the floor id
     * @param regionId the region id
     * @param mapId the map id
     * @return the map in the region on the floor of the continent
     */
    suspend fun Transaction.getContinentMap(continentId: ContinentId, floorId: FloorId, regionId: RegionId, mapId: MapId): ContinentMap? {
        val region = getContinentRegion(continentId, floorId, regionId)
        return region?.maps?.get(mapId)
    }

    /**
     * Clears the [Continent], [Floor], [Region], [ContinentMap], and [Map] models.
     */
    override fun Transaction.clear() {
        clear<Continent>()
        clear<Floor>()
        clear<Map>()

        // These models come from ContinentFloor and thus shouldn't be in the cache, but they are related so they should be deleted.
        clear<Region>()
        clear<ContinentMap>()
    }
}