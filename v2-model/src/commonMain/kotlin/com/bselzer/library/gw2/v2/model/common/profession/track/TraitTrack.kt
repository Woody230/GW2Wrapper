package com.bselzer.library.gw2.v2.model.common.profession.track

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Trait")
data class TraitTrack(
    override val cost: Int = 0,

    /**
     * The id of the trait.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    @SerialName("trait_id")
    val id: Int = 0
) : TrainingTrack()