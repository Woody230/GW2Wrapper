package com.bselzer.library.gw2.v2.model.common.skill.fact

import com.bselzer.library.gw2.v2.model.common.skill.Skill
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
open class SkillFact(
    /**
     * The description of the fact.
     */
    @SerialName("text")
    val description: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    /**
     * The id of the required trait.
     *
     * Null if this is not a traited fact.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    @SerialName("requires_trait")
    val traitId: Int? = null,

    /**
     * The index of the fact in the [Skill.facts] that is overridden when the trait associated with [traitId] is selected.
     *
     * Null if there is no trait to override.
     */
    @SerialName("overrides")
    val overrides: Int? = null
)
{
    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as SkillFact

        if (description != other.description) return false
        if (iconLink != other.iconLink) return false
        if (traitId != other.traitId) return false
        if (overrides != other.overrides) return false

        return true
    }

    override fun hashCode(): Int
    {
        var result = description.hashCode()
        result = 31 * result + iconLink.hashCode()
        result = 31 * result + (traitId ?: 0)
        result = 31 * result + (overrides ?: 0)
        return result
    }
}