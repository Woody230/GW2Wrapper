package com.bselzer.gw2.v2.model.wvw.ability

import com.bselzer.gw2.v2.model.wrapper.ImageLink
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwAbility(
    @SerialName("id")
    override val id: WvwAbilityId = WvwAbilityId(),

    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    @SerialName("icon")
    val iconLink: ImageLink = ImageLink(),

    @SerialName("ranks")
    val ranks: List<WvwAbilityRank> = emptyList()
) : Identifiable<Int>