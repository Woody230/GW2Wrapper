package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.model.file.Asset
import com.bselzer.gw2.v2.model.file.AssetId
import io.ktor.client.*

/**
 * The file client for commonly requests in-game assets.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/files">the wiki</a>
 */
class FileClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val FILES = "files"
    }

    /**
     * @return the ids of the commonly requested assets
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/files">the wiki</a>
     */
    suspend fun ids(): List<AssetId> = getIds(path = FILES)

    /**
     * @return the commonly requested asset associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/files">the wiki</a>
     */
    suspend fun asset(id: AssetId): Asset = getSingleById(id, FILES, instance = { Asset(id = it) })

    /**
     * @return the commonly requested assets associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/files">the wiki</a>
     */
    suspend fun assets(ids: Collection<AssetId>): List<Asset> = chunkedIds(ids, FILES, instance = { Asset(id = it) })

    /**
     * @return all the commonly requests assets
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/files">the wiki</a>
     */
    suspend fun assets(): List<Asset> = allIds(FILES)
}