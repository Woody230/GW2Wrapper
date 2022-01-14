package com.bselzer.gw2.v2.model.enumeration.character

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class RaceName {
    @SerialName("Asura")
    ASURA,

    @SerialName("Charr")
    CHARR,

    @SerialName("Human")
    HUMAN,

    @SerialName("Norn")
    NORN,

    @SerialName("Sylvari")
    SYLVARI;
}