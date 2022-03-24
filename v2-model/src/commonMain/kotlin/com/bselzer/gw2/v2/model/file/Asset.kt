package com.bselzer.gw2.v2.model.file

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.wrapper.ImageLink
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Asset(
    @SerialName("id")
    override val id: AssetId = AssetId(),

    @SerialName("icon")
    val iconLink: ImageLink = ImageLink()
) : Identifiable<String>