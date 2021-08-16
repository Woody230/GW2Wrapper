package com.bselzer.library.gw2.v2.model.extension.common.enumeration.world

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class WorldLanguage
{
    @SerialName("0")
    ENGLISH,

    @SerialName("1")
    FRENCH,

    @SerialName("2")
    GERMAN,

    @SerialName("3")
    SPANISH
}