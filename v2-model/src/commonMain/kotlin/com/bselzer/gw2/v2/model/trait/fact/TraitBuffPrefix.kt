package com.bselzer.gw2.v2.model.trait.fact

import com.bselzer.gw2.v2.model.wrapper.ImageLink
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TraitBuffPrefix(
    @SerialName("text")
    val description: String = "",

    @SerialName("icon")
    val iconLink: ImageLink = ImageLink(),

    @SerialName("status")
    val status: String = "",

    @SerialName("description")
    val effectDescription: String = ""
)
