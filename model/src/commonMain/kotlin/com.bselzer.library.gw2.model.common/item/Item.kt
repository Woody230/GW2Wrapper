package com.bselzer.library.gw2.model.common.item

import com.bselzer.library.gw2.model.common.Rarity
import com.bselzer.library.gw2.model.common.item.detail.ItemDetail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Item(
    @SerialName("id")
    val id: Int,

    @SerialName("chat_link")
    val chatLink: String = "",

    @SerialName("name")
    val name: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("description")
    val description: String = "",

    @SerialName("type")
    val type: ItemType? = null,

    @SerialName("rarity")
    val rarity: Rarity? = null,

    @SerialName("level")
    val levelRequired: Int = 0,

    @SerialName("vendor_value")
    val vendorValue: Int = 0,

    @SerialName("default_skin")
    val defaultSkinId: Int = 0,

    @SerialName("flags")
    val flags: List<ItemFlag> = emptyList(),

    @SerialName("game_types")
    val usableGameTypes: List<ItemGameType> = emptyList(),

    @SerialName("restrictions")
    val restrictions: List<ItemRestriction> = emptyList(),

    @SerialName("details")
    val detail: ItemDetail = ItemDetail()
)
