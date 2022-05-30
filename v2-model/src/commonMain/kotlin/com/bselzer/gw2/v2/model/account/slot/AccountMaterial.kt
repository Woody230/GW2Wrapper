package com.bselzer.gw2.v2.model.account.slot

import com.bselzer.gw2.v2.model.enumeration.wrapper.Binding
import com.bselzer.gw2.v2.model.item.ItemId
import com.bselzer.gw2.v2.model.material.MaterialId
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountMaterial(
    /**
     * The id of the material in the items endpoint.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/items">the wiki</a>
     */
    @SerialName("id")
    override val id: ItemId = ItemId(),

    /**
     * The id of the material category in the materials endpoint.
     * <a href="https://wiki.guildwars2.com/wiki/API:2/materials">the wiki</a>
     */
    @SerialName("category")
    val categoryId: MaterialId = MaterialId(),

    /**
     * What owns this item. Null if there is no binding.
     */
    @SerialName("binding")
    val binding: Binding? = null,

    /**
     * The number of the material in the account vault.
     */
    val count: Int = 0
) : Identifiable<ItemId, Int>