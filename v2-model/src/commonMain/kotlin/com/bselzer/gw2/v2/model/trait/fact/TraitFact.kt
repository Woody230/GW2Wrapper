package com.bselzer.gw2.v2.model.trait.fact

import com.bselzer.gw2.v2.model.trait.Trait
import com.bselzer.gw2.v2.model.trait.TraitId
import com.bselzer.gw2.v2.model.wrapper.ImageLink
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
abstract class TraitFact(
    /**
     * The description of the fact.
     */
    @SerialName("text")
    val description: String = "",

    @SerialName("icon")
    val iconLink: ImageLink = ImageLink(),

    /**
     * The id of the required trait.
     *
     * Null if this is not a traited fact.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    @SerialName("requires_trait")
    val traitId: TraitId? = null,

    /**
     * The index of the fact in the [Trait.facts] that is overridden when the trait associated with [traitId] is selected.
     *
     * Null if there is no trait to override.
     */
    @SerialName("overrides")
    val overrides: Int? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as TraitFact

        if (description != other.description) return false
        if (iconLink != other.iconLink) return false
        if (traitId != other.traitId) return false
        if (overrides != other.overrides) return false

        return true
    }

    override fun hashCode(): Int {
        var result = description.hashCode()
        result = 31 * result + iconLink.hashCode()
        result = 31 * result + (traitId?.hashCode() ?: 0)
        result = 31 * result + (overrides ?: 0)
        return result
    }
}