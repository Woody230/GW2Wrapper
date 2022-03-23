package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The languages supported by the API.
 * @see <a href="https://api.guildwars2.com/v2">https://api.guildwars2.com/v2</a>
 */
@Serializable
enum class Language {
    @SerialName("en")
    ENGLISH,

    @SerialName("es")
    SPANISH,

    @SerialName("de")
    GERMAN,

    @SerialName("fr")
    FRENCH,

    @SerialName("zh")
    CHINESE
}