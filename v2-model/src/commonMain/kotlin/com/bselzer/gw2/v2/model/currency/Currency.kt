package com.bselzer.gw2.v2.model.currency

import com.bselzer.gw2.v2.model.wrapper.ImageLink
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Currency(
    @SerialName("id")
    override val id: CurrencyId = CurrencyId(),

    // TODO enum and extension
    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    @SerialName("icon")
    val iconLink: ImageLink = ImageLink(),

    /**
     * The order of appearance among all currencies. A collection of currencies should be ordered from least to greatest.
     */
    @SerialName("order")
    val order: Int = 0
) : Identifiable<Int>