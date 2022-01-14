package com.bselzer.gw2.v2.model.character

import com.bselzer.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterSpecialization(
    /**
     * The id of the selected specialization.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki</a>
     */
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The ids of the selected traits.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    @SerialName("traits")
    val traits: List<Int?> = emptyList()
) : Identifiable<Int>