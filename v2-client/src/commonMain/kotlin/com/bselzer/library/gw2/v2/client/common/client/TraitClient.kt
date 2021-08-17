package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.trait.Trait
import io.ktor.client.*

/**
 * The trait client.
 * <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
 */
class TraitClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val TRAITS = "traits"
    }

    /**
     * @return the ids of the available traits
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    suspend fun ids(): List<Int> = get(path = TRAITS)

    /**
     * @return the trait associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    suspend fun trait(id: Int, language: String? = null): Trait = single(id, TRAITS) {
        language(language)
    }

    /**
     * @return the traits associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    suspend fun traits(ids: Collection<Int>, language: String? = null): List<Trait> = chunkedIds(ids, TRAITS) {
        language(language)
    }

    /**
     * @return all the traits
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    suspend fun traits(language: String? = null): List<Trait> = allIds(TRAITS) {
        language(language)
    }
}