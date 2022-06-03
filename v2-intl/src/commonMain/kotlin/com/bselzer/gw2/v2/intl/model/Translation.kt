package com.bselzer.gw2.v2.intl.model

import kotlinx.serialization.Serializable

@Serializable
data class Translation(
    /**
     * The default English text.
     */
    val default: String,

    /**
     * The translated version of the [default] text.
     */
    val translated: String,

    /**
     * The language the [translated] text is in.
     */
    val language: String,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Translation

        if (default != other.default) return false
        if (language != other.language) return false

        return true
    }

    override fun hashCode(): Int {
        var result = default.hashCode()
        result = 31 * result + language.hashCode()
        return result
    }
}