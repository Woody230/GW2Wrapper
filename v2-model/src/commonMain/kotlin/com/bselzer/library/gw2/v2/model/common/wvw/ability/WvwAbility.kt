package com.bselzer.library.gw2.v2.model.common.wvw.ability

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwAbility(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    @SerialName("icon")
    val icon: String = "",

    @SerialName("ranks")
    val ranks: List<WvwAbilityRank> = emptyList()
) : Identifiable<Int>