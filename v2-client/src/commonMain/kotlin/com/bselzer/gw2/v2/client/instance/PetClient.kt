package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.request.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.model.pet.Pet
import com.bselzer.gw2.v2.model.pet.PetId
import io.ktor.client.*

/**
 * The pet client. For Rangers.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pets">the wiki</a>
 */
class PetClient(httpClient: HttpClient, configuration: DefaultGw2HttpOptions) : BaseClient(httpClient, configuration) {
    private companion object {
        const val PETS = "pets"
    }

    /**
     * @return the ids of the available pets
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pets">the wiki</a>
     */
    suspend fun ids(): List<PetId> = getIds(path = PETS)

    /**
     * @return the pet associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pets">the wiki</a>
     */
    suspend fun pet(id: PetId, language: Language? = null): Pet = getSingleById(id, PETS, instance = { Pet(id = it) }) {
        language(language)
    }

    /**
     * @return the pets associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pets">the wiki</a>
     */
    suspend fun pets(ids: Collection<PetId>, language: Language? = null): List<Pet> = chunkedIds(ids, PETS, instance = { Pet(id = it) }) {
        language(language)
    }

    /**
     * @return all the pets
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pets">the wiki</a>
     */
    suspend fun pets(language: Language? = null): List<Pet> = allIds(PETS) {
        language(language)
    }
}