package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.model.pet.Pet
import io.ktor.client.*

/**
 * The pet client. For Rangers.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pets">the wiki</a>
 */
class PetClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val PETS = "pets"
    }

    /**
     * @return the ids of the available pets
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pets">the wiki</a>
     */
    suspend fun ids(): List<Int> = getList(path = PETS)

    /**
     * @return the pet associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pets">the wiki</a>
     */
    suspend fun pet(id: Int, language: String? = null): Pet = getSingleById(id, PETS) {
        language(language)
    }

    /**
     * @return the pets associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pets">the wiki</a>
     */
    suspend fun pets(ids: Collection<Int>, language: String? = null): List<Pet> = chunkedIds(ids, PETS) {
        language(language)
    }

    /**
     * @return all the pets
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pets">the wiki</a>
     */
    suspend fun pets(language: String? = null): List<Pet> = allIds(PETS) {
        language(language)
    }
}