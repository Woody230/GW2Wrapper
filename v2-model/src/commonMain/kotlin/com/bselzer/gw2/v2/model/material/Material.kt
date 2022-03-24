package com.bselzer.gw2.v2.model.material

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.item.ItemId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Material(
    @SerialName("id")
    override val id: MaterialId = MaterialId(),

    /**
     * The name of the category.
     */
    @SerialName("name")
    val name: String = "",

    /**
     * The ids of the items in this category.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("items")
    val itemIds: List<ItemId> = emptyList(),

    /**
     * The order in which this category appears in material storage.
     */
    @SerialName("order")
    val order: Int = 0
) : Identifiable<Int>