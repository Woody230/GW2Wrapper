package com.bselzer.gw2.v2.model.item

import com.bselzer.gw2.v2.model.character.CharacterLevel
import com.bselzer.gw2.v2.model.enumeration.wrapper.ItemFlag
import com.bselzer.gw2.v2.model.enumeration.wrapper.ItemGameType
import com.bselzer.gw2.v2.model.enumeration.wrapper.ItemRarity
import com.bselzer.gw2.v2.model.enumeration.wrapper.ItemRestriction
import com.bselzer.gw2.v2.model.skin.SkinId
import com.bselzer.gw2.v2.model.wrapper.ChatLink
import com.bselzer.gw2.v2.model.wrapper.ImageLink
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
abstract class Item(
    @SerialName("id")
    override val id: ItemId = ItemId(),

    /**
     * The chat link.
     * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format#Item_link">the wiki</a>
     */
    @SerialName("chat_link")
    val chatLink: ChatLink = ChatLink(),

    @SerialName("name")
    val name: String = "",

    @SerialName("icon")
    val iconLink: ImageLink = ImageLink(),

    @SerialName("description")
    val description: String = "",

    @SerialName("rarity")
    val rarity: ItemRarity = ItemRarity(),

    /**
     * The level required to use this item.
     */
    @SerialName("level")
    val level: CharacterLevel = CharacterLevel(),

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
    val defaultSkinId: SkinId = SkinId(),

    @SerialName("flags")
    val flags: List<ItemFlag> = emptyList(),

    /**
     * The game types this item is usable in.
     */
    @SerialName("game_types")
    val gameTypes: List<ItemGameType> = emptyList(),

    @SerialName("restrictions")
    val restrictions: List<ItemRestriction> = emptyList()
) : Identifiable<Int> {
    override fun equals(other: Any?): Boolean {
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

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + chatLink.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + iconLink.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + rarity.hashCode()
        result = 31 * result + level.hashCode()
        result = 31 * result + vendorValue.hashCode()
        result = 31 * result + defaultSkinId.hashCode()
        result = 31 * result + flags.hashCode()
        result = 31 * result + gameTypes.hashCode()
        result = 31 * result + restrictions.hashCode()
        return result
    }
}
