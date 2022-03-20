package com.bselzer.gw2.v2.model.recipe.ingredient

import com.bselzer.gw2.v2.model.item.ItemId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeIngredient(
    /**
     * The id of the ingredient item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("item_id")
    val itemId: ItemId = ItemId(),

    /**
     * The number of the item associated with the [itemId] required.
     */
    @SerialName("count")
    val count: Int = 0
)