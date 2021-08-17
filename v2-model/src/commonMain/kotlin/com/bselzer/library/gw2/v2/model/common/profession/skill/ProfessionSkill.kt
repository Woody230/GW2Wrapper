package com.bselzer.library.gw2.v2.model.common.profession.skill

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
open class ProfessionSkill(
    /**
     * The id of the skill.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The skill slot the skill belongs to.
     */
    @SerialName("slot")
    val slot: String = "",
) : Identifiable<Int>
{
    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as ProfessionSkill

        if (id != other.id) return false
        if (slot != other.slot) return false

        return true
    }

    override fun hashCode(): Int
    {
        var result = id
        result = 31 * result + slot.hashCode()
        return result
    }
}