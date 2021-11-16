package com.bselzer.library.gw2.v2.cache.instance

import com.bselzer.library.gw2.v2.client.client.Gw2Client
import com.bselzer.library.gw2.v2.model.continent.Continent
import com.bselzer.library.gw2.v2.model.continent.ContinentFloor
import com.bselzer.library.gw2.v2.model.continent.ContinentRegion
import com.bselzer.library.gw2.v2.model.continent.map.ContinentMap
import com.bselzer.library.gw2.v2.model.map.Map
import com.bselzer.library.kotlin.extension.kodein.db.operation.clear
import com.bselzer.library.kotlin.extension.kodein.db.operation.getById
import com.bselzer.library.kotlin.extension.kodein.db.transaction.TransactionStarter

/**
 * Represents a cache for models related to [Continent].
 */
class ContinentCache(transactionStarter: TransactionStarter, client: Gw2Client) : Gw2Cache(transactionStarter, client) {
    /**
     * Puts the map with the given [id] and its associated continent and default floor.
     *
     * @param id the id of the map
     */
    suspend fun putMap(id: Int) = transaction {
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
    suspend fun getMap(id: Int) = runTransaction {
        getById(id, { client.map.map(id) })
    }

    /**
     * Gets the continent associated with the map.
     *
     * If there is no continent in the database, then the api is called.
     *
     * @param map the map
     * @return the continent
     */
    suspend fun getContinent(map: Map) = getContinent(map.continentId)

    /**
     * Gets the default floor associated with the map.
     *
     * If there is no floor in the database, then the api is called.
     *
     * @param map the map
     * @return the default floor
     */
    suspend fun getContinentFloor(map: Map) = getContinentFloor(map.continentId, map.defaultFloorId)

    /**
     * Gets the region from the default floor associated with the map.
     *
     * @param map the map
     * @return the region from the default floor
     */
    suspend fun getContinentRegion(map: Map) = getContinentRegion(map.continentId, map.defaultFloorId, map.regionId)

    /**
     * Gets the map from the continents endpoint associated with the map from the maps endpoint.
     *
     * @param map the map
     * @return the continent map
     */
    suspend fun getContinentMap(map: Map) = getContinentMap(map.continentId, map.defaultFloorId, map.regionId, map.id)

    /**
     * Gets the continent with the given [id].
     *
     * @param id the id
     * @return the continent
     */
    suspend fun getContinent(id: Int) = runTransaction {
        getById(id, { client.continent.continent(id) })
    }

    /**
     * Gets the floor with the given [floorId] from the continent with the given [continentId].
     *
     * @param continentId the continent id
     * @param floorId the floor id
     * @return the floor of the continent
     */
    suspend fun getContinentFloor(continentId: Int, floorId: Int) = runTransaction {
        getById(floorId, { client.continent.floor(continentId, floorId) })
    }

    /**
     * Gets the region with the given [regionId] from the floor in the continent with the [floorId] and [continentId] respectively.
     *
     * @param continentId the continent id
     * @param floorId the floor id
     * @param regionId the region id
     * @return the region on the floor of the continent
     */
    suspend fun getContinentRegion(continentId: Int, floorId: Int, regionId: Int) = runTransaction {
        val floor = getContinentFloor(continentId, floorId)
        floor.regions[regionId]
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
    suspend fun getContinentMap(continentId: Int, floorId: Int, regionId: Int, mapId: Int) {
        val region = getContinentRegion(continentId, floorId, regionId)
        region?.maps?.get(mapId)
    }

    /**
     * Clears the [Continent], [ContinentFloor], [ContinentRegion], [ContinentMap], and [Map] models.
     */
    override suspend fun clear() = transaction {
        clear<Continent>()
        clear<ContinentFloor>()
        clear<Map>()

        // These models are currently not populated by this cache since they come from ContinentFloor, but they are related so they should be deleted.
        clear<ContinentRegion>()
        clear<ContinentMap>()
    }
}