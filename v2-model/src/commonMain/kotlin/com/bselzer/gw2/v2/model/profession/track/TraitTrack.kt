package com.bselzer.gw2.v2.model.profession.track

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.trait.TraitId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Trait")
data class TraitTrack(
    /**
     * The id of the trait.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    @SerialName("trait_id")
    override val id: TraitId = TraitId()
) : TrainingTrack(), Identifiable<Int>