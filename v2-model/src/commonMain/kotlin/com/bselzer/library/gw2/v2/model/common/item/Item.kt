package com.bselzer.library.gw2.v2.model.common.item

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
abstract class Item(
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The chat link.
     * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format#Item_link">the wiki</a>
     */
    @SerialName("chat_link")
    val chatLink: String = "",

    @SerialName("name")
    val name: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("description")
    val description: String = "",

    @SerialName("rarity")
    val rarity: String = "",

    /**
     * The level required to use this item.
     */
    @SerialName("level")
    val level: Int = 0,

    /**
     * The coin value when selling to a vendor.
     */
    @SerialName("vendor_value")
    val vendorValue: Int = 0,

    /**
     * The id of the skin.
     * @see <a href="https://wiki.guildwars2.com/wiki/Skin">the wiki</a>
     */
    @SerialName("default_skin")
    val defaultSkinId: Int = 0,

    @SerialName("flags")
    val flags: List<String> = emptyList(),

    /**
     * The game types this item is usable in.
     */
    @SerialName("game_types")
    val gameTypes: List<String> = emptyList(),

    @SerialName("restrictions")
    val restrictions: List<String> = emptyList()
) : Identifiable<Int>
{
    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Item

        if (id != other.id) return false
        if (chatLink != other.chatLink) return false
        if (name != other.name) return false
        if (iconLink != other.iconLink) return false
        if (description != other.description) return false
        if (rarity != other.rarity) return false
        if (level != other.level) return false
        if (vendorValue != other.vendorValue) return false
        if (defaultSkinId != other.defaultSkinId) return false
        if (flags != other.flags) return false
        if (gameTypes != other.gameTypes) return false
        if (restrictions != other.restrictions) return false

        return true
    }

    override fun hashCode(): Int
    {
        var result = id
        result = 31 * result + chatLink.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + iconLink.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + rarity.hashCode()
        result = 31 * result + level
        result = 31 * result + vendorValue
        result = 31 * result + defaultSkinId
        result = 31 * result + flags.hashCode()
        result = 31 * result + gameTypes.hashCode()
        result = 31 * result + restrictions.hashCode()
        return result
    }
}
