package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Files
import com.bselzer.library.gw2.v2.model.common.file.Asset
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The file client for commonly requests in-game assets.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/files">the wiki</a>
 */
class FileClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the commonly requested assets
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/files">the wiki</a>
     */
    suspend fun ids(): List<String> = httpClient.get(path = Files.FILES)

    /**
     * @return the commonly requested asset associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/files">the wiki</a>
     */
    suspend fun asset(id: String): Asset = single(id, Files.FILES)

    /**
     * @return the commonly requested assets associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/files">the wiki</a>
     */
    suspend fun assets(ids: Collection<String>): List<Asset> = chunkedIds(ids, Files.FILES)

    /**
     * @return all the commonly requests assets
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/files">the wiki</a>
     */
    suspend fun assets(): List<Asset> = allIds(Files.FILES)
}