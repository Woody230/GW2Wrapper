package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Pets
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.pet.Pet
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The pet client. For Rangers.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pets">the wiki</a>
 */
class PetClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available pets
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pets">the wiki</a>
     */
    suspend fun ids(): List<Int> = httpClient.get(path = Pets.PETS)

    /**
     * @return the pets associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pets">the wiki</a>
     */
    suspend fun pets(ids: Collection<Int>, language: String? = null): List<Pet> = chunkedIds(ids, Pets.PETS) {
        language(language)
    }

    /**
     * @return all the pets
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pets">the wiki</a>
     */
    suspend fun pets(language: String? = null): List<Pet> = allIds(Pets.PETS) {
        language(language)
    }
}