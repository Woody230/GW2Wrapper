package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Traits
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.trait.Trait
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The trait client.
 * <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
 */
class TraitClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available traits
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    suspend fun ids(): List<Int> = httpClient.get(path = Traits.TRAITS)

    /**
     * @return the trait associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    suspend fun trait(id: Int, language: String? = null): Trait = single(id, Traits.TRAITS) {
        language(language)
    }

    /**
     * @return the traits associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    suspend fun traits(ids: Collection<Int>, language: String? = null): List<Trait> = chunkedIds(ids, Traits.TRAITS) {
        language(language)
    }

    /**
     * @return all the traits
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    suspend fun traits(language: String? = null): List<Trait> = allIds(Traits.TRAITS) {
        language(language)
    }
}