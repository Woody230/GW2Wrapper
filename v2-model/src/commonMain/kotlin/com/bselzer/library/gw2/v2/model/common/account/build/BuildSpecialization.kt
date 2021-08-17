package com.bselzer.library.gw2.v2.model.common.account.build

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BuildSpecialization(
    /**
     * The id of the specialization.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki</a>
     */
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The ids of the selected traits.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    @SerialName("traits")
    val traitIds: List<Int> = emptyList()
) : Identifiable<Int>