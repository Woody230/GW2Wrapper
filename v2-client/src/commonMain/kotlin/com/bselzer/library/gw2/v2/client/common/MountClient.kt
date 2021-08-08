package com.bselzer.library.gw2.v2.client.common

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Mounts
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.mount.MountSkin
import com.bselzer.library.gw2.v2.model.common.mount.MountType
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The mount client.
 * @see <a href='https://wiki.guildwars2.com/wiki/API:2/mounts">the wiki</a>
 */
class MountClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available skins
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mounts/skins">the wiki</a>
     */
    suspend fun skinIds(): List<Int> = httpClient.get(path = "${Mounts.MOUNTS}/${Mounts.SKINS}")

    /**
     * @return the skins associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mounts/skins">the wiki</a>
     */
    suspend fun skins(ids: Collection<Int>, language: String? = null): List<MountSkin> = chunkedIds(ids, "${Mounts.MOUNTS}/${Mounts.SKINS}") {
        language(language)
    }

    /**
     * @return all the skins
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mounts/skins">the wiki</a>
     */
    suspend fun skins(language: String? = null): List<MountSkin> = allIds("${Mounts.MOUNTS}/${Mounts.SKINS}") {
        language(language)
    }

    /**
     * @return the ids of the available types
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mounts/types">the wiki</a>
     */
    suspend fun typeIds(): List<String> = httpClient.get(path = "${Mounts.MOUNTS}/${Mounts.TYPES}")

    /**
     * @return the types associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mounts/types">the wiki</a>
     */
    suspend fun types(ids: Collection<String>, language: String? = null): List<MountType> = chunkedIds(ids, "${Mounts.MOUNTS}/${Mounts.TYPES}") {
        language(language)
    }

    /**
     * @return all the types
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mounts/types">the wiki</a>
     */
    suspend fun types(language: String? = null): List<MountType> = allIds("${Mounts.MOUNTS}/${Mounts.TYPES}") {
        language(language)
    }
}