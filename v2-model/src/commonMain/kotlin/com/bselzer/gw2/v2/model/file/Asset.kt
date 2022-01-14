package com.bselzer.gw2.v2.model.file

import com.bselzer.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Asset(
    @SerialName("id")
    override val id: String = "",

    @SerialName("icon")
    val iconLink: String = ""
) : Identifiable<String>