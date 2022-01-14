package com.bselzer.gw2.v2.model.enumeration.scope

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Accessibility {
    @SerialName("HasAccess")
    ACCESSIBLE,

    @SerialName("NoAccess")
    INACCESSIBLE
}