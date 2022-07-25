package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.request.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.model.trait.Trait
import com.bselzer.gw2.v2.model.trait.TraitId
import io.ktor.client.*

/**
 * The trait client.
 * <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
 */
class TraitClient(httpClient: HttpClient, configuration: DefaultGw2HttpOptions) : BaseClient(httpClient, configuration) {
    private companion object {
        const val TRAITS = "traits"
    }

    /**
     * @return the ids of the available traits
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    suspend fun ids(): List<TraitId> = getIds(path = TRAITS)

    /**
     * @return the trait associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    suspend fun trait(id: TraitId, language: Language? = null): Trait = getSingleById(id, TRAITS, instance = { Trait(id = it) }) {
        language(language)
    }

    /**
     * @return the traits associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    suspend fun traits(ids: Collection<TraitId>, language: Language? = null): List<Trait> = chunkedIds(ids, TRAITS, instance = { Trait(id = it) }) {
        language(language)
    }

    /**
     * @return all the traits
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    suspend fun traits(language: Language? = null): List<Trait> = allIds(TRAITS) {
        language(language)
    }
}