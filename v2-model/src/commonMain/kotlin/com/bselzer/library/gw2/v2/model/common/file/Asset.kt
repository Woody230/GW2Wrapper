package com.bselzer.library.gw2.v2.model.common.file

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Asset(
    @SerialName("id")
    override val id: String = "",

    @SerialName("icon")
    val iconLink: String = ""
) : Identifiable<String>