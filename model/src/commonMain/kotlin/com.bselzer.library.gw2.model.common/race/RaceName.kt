package com.bselzer.library.gw2.model.common.race

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class RaceName
{
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