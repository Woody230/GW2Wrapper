package com.bselzer.gw2.v2.model.quaggan

import com.bselzer.gw2.v2.model.wrapper.ImageLink
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Quaggan(
    @SerialName("id")
    override val id: QuagganId = QuagganId(),

    @SerialName("url")
    val iconLink: ImageLink = ImageLink()
) : Identifiable<QuagganId, String>