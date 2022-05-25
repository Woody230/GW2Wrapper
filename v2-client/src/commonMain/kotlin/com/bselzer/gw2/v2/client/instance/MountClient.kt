package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.model.Language
import com.bselzer.gw2.v2.model.mount.skin.MountSkin
import com.bselzer.gw2.v2.model.mount.skin.MountSkinId
import com.bselzer.gw2.v2.model.mount.type.MountType
import com.bselzer.gw2.v2.model.mount.type.MountTypeId
import io.ktor.client.*

/**
 * The mount client.
 * @see <a href='https://wiki.guildwars2.com/wiki/API:2/mounts">the wiki</a>
 */
class MountClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val MOUNTS = "mounts"
        const val SKINS = "skins"
        const val TYPES = "types"
    }

    /**
     * @return the ids of the available skins
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mounts/skins">the wiki</a>
     */
    suspend fun skinIds(): List<MountSkinId> = getIds(path = "${MOUNTS}/${SKINS}")

    /**
     * @return the skin associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mounts/skins">the wiki</a>
     */
    suspend fun skin(id: MountSkinId, language: Language? = null): MountSkin = getSingleById(id, "${MOUNTS}/${SKINS}", instance = { MountSkin(id = it) }) {
        language(language)
    }

    /**
     * @return the skins associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mounts/skins">the wiki</a>
     */
    suspend fun skins(ids: Collection<MountSkinId>, language: Language? = null): List<MountSkin> = chunkedIds(ids, "${MOUNTS}/${SKINS}", instance = { MountSkin(id = it) }) {
        language(language)
    }

    /**
     * @return all the skins
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mounts/skins">the wiki</a>
     */
    suspend fun skins(language: Language? = null): List<MountSkin> = allIds("${MOUNTS}/${SKINS}") {
        language(language)
    }

    /**
     * @return the ids of the available types
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mounts/types">the wiki</a>
     */
    suspend fun typeIds(): List<MountTypeId> = getIds(path = "${MOUNTS}/${TYPES}")

    /**
     * @return the type associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mounts/types">the wiki</a>
     */
    suspend fun type(id: MountTypeId, language: Language? = null): MountType = getSingleById(id, "${MOUNTS}/${TYPES}", instance = { MountType(id = it) }) {
        language(language)
    }

    /**
     * @return the types associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mounts/types">the wiki</a>
     */
    suspend fun types(ids: Collection<MountTypeId>, language: Language? = null): List<MountType> = chunkedIds(ids, "${MOUNTS}/${TYPES}", instance = { MountType(id = it) }) {
        language(language)
    }

    /**
     * @return all the types
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mounts/types">the wiki</a>
     */
    suspend fun types(language: Language? = null): List<MountType> = allIds("${MOUNTS}/${TYPES}") {
        language(language)
    }
}