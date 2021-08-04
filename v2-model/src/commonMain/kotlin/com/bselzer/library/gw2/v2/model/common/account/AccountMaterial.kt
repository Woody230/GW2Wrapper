package com.bselzer.library.gw2.v2.model.common.account

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountMaterial(
    /**
     * The id of the material in the items endpoint.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("id")
    val itemId: Int = 0,

    /**
     * The id of the material category in the materials endpoint.
     * <a href="https://wiki.guildwars2.com/wiki/API:2/materials">the wiki</a>
     */
    @SerialName("category")
    val categoryId: Int = 0,

    /**
     * What owns this item. Null if there is no binding.
     */
    @SerialName("binding")
    val binding: String? = null,

    /**
     * The number of the material in the account vault.
     */
    val count: Int = 0
)