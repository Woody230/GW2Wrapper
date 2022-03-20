package com.bselzer.gw2.v2.model.color

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.item.ItemId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DyeColor(
    @SerialName("id")
    override val id: DyeColorId = DyeColorId(),

    @SerialName("name")
    val name: String = "",

    // TODO custom class
    /**
     * The red, green, and blue values.
     */
    @SerialName("base_rgb")
    val baseRgb: List<Int> = emptyList(),

    /**
     * The appearance for cloth armors.
     */
    @SerialName("cloth")
    val cloth: ColorAppearance = ColorAppearance(),

    /**
     * The appearance for leather armors.
     */
    @SerialName("leather")
    val leather: ColorAppearance = ColorAppearance(),

    /**
     * The appearance for metal armors.
     */
    @SerialName("metal")
    val metal: ColorAppearance = ColorAppearance(),

    /**
     * The appearance for fur armors.
     */
    @SerialName("fur")
    val fur: ColorAppearance = ColorAppearance(),

    /**
     * The id of the dye as an item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("item")
    val itemId: ItemId = ItemId(),

    /**
     * The types of hue, material, and rarity.
     */
    @SerialName("categories")
    val categories: List<String> = emptyList()
) : Identifiable<Int>