package com.bselzer.library.gw2.v2.client.client

import com.bselzer.library.gw2.v2.client.extension.language
import com.bselzer.library.gw2.v2.model.material.Material
import io.ktor.client.*

/**
 * The material client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/materials">the wiki</a>
 */
class MaterialClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val MATERIALS = "materials"
    }

    /**
     * @return the ids of the available materials
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/materials">the wiki</a>
     */
    suspend fun ids(): List<Int> = getList(path = MATERIALS)

    /**
     * @return the material associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/materials">the wiki</a>
     */
    suspend fun material(id: Int, language: String? = null): Material = getSingleById(id, MATERIALS) {
        language(language)
    }

    /**
     * @return the materials associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/materials">the wiki</a>
     */
    suspend fun materials(ids: Collection<Int>, language: String? = null): List<Material> = chunkedIds(ids, MATERIALS) {
        language(language)
    }

    /**
     * @return all the materials
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/materials">the wiki</a>
     */
    suspend fun materials(language: String? = null): List<Material> = allIds(MATERIALS) {
        language(language)
    }
}