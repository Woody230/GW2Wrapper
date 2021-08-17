package com.bselzer.library.gw2.v2.model.common.quaggan

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Quaggan(
    @SerialName("id")
    override val id: String = "",

    @SerialName("url")
    val iconLink: String = ""
) : Identifiable<String>