package com.bselzer.library.gw2.v2.model.common.skin

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
abstract class Skin(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("name")
    val name: String = "",

    @SerialName("flags")
    val flags: List<String> = emptyList(),

    /**
     * The names of the races that are able to apply the skin.
     *
     * Empty if there are no restrictions.
     */
    @SerialName("restrictions")
    val restrictions: List<String> = emptyList(),

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("rarity")
    val rarity: String = "",

    @SerialName("description")
    val description: String = ""
) : Identifiable<Int>
{
    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Skin

        if (id != other.id) return false
        if (name != other.name) return false
        if (flags != other.flags) return false
        if (restrictions != other.restrictions) return false
        if (iconLink != other.iconLink) return false
        if (rarity != other.rarity) return false
        if (description != other.description) return false

        return true
    }

    override fun hashCode(): Int
    {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + flags.hashCode()
        result = 31 * result + restrictions.hashCode()
        result = 31 * result + iconLink.hashCode()
        result = 31 * result + rarity.hashCode()
        result = 31 * result + description.hashCode()
        return result
    }
}