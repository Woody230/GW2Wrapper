package com.bselzer.library.gw2.v2.model.common.material

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Material(
    @SerialName("id")
    val id: Int = 0,

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
    val itemIds: List<Int> = emptyList(),

    /**
     * The order in which this category appears in material storage.
     */
    @SerialName("order")
    val order: Int = 0
)