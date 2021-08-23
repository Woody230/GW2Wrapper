package com.bselzer.library.gw2.v2.model.race

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Race(
    @SerialName("id")
    override val id: String,

    @SerialName("name")
    val name: String = "",

    /**
     * The ids of the skills usable by characters of this race.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("skills")
    val skillIds: List<Int> = emptyList()
) : Identifiable<String>