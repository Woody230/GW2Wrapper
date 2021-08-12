package com.bselzer.library.gw2.v2.model.common.trait.fact

import com.bselzer.library.gw2.v2.model.common.trait.Trait
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
abstract class TraitFact
{
    /**
     * The description of the fact.
     */
    @SerialName("text")
    val description: String = ""

    @SerialName("icon")
    val iconLink: String = ""

    /**
     * The id of the required trait.
     *
     * Null if this is not a traited fact.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    @SerialName("requires_trait")
    val traitId: Int? = null

    /**
     * The index of the fact in the [Trait.facts] that is overridden when the trait associated with [traitId] is selected.
     *
     * Null if there is no trait to override.
     */
    @SerialName("overrides")
    val overrides: Int? = null
}