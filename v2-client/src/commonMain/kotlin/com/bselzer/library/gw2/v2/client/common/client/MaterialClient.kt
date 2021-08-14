package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Materials
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.material.Material
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The material client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/materials">the wiki</a>
 */
class MaterialClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available materials
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/materials">the wiki</a>
     */
    suspend fun ids(): List<Int> = httpClient.get(path = Materials.MATERIALS)

    /**
     * @return the materials associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/materials">the wiki</a>
     */
    suspend fun materials(ids: Collection<Int>, language: String? = null): List<Material> = chunkedIds(ids, Materials.MATERIALS) {
        language(language)
    }

    /**
     * @return all the materials
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/materials">the wiki</a>
     */
    suspend fun materials(language: String? = null): List<Material> = allIds(Materials.MATERIALS) {
        language(language)
    }
}