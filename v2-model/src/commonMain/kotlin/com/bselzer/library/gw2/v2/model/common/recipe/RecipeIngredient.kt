package com.bselzer.library.gw2.v2.model.common.recipe

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeIngredient(
    /**
     * The id of the ingredient item.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("item_id")
    val itemId: Int = 0,

    /**
     * The number of the item associated with the [itemId] required.
     */
    @SerialName("count")
    val count: Int = 0
)