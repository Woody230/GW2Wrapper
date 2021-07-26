package com.bselzer.library.gw2.model.common.mechanics.item

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
    val type: String = "",

    @SerialName("rarity")
    val rarity: String = "",

    @SerialName("level")
    val levelRequired: Int = 0,

    @SerialName("vendor_value")
    val vendorValue: Int = 0,

    @SerialName("default_skin")
    val defaultSkinId: Int = 0,

    @SerialName("flags")
    val flags: List<String> = emptyList(),

    @SerialName("game_types")
    val usableGameTypes: List<String> = emptyList(),

    @SerialName("restrictions")
    val restrictions: List<String> = emptyList(),

    @SerialName("details")
    val detail: ItemDetail = ItemDetail()
)
