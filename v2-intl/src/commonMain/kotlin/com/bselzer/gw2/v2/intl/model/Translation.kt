package com.bselzer.gw2.v2.intl.model

import kotlinx.serialization.Serializable

@Serializable
data class Translation(
    val text: String,

    /**
     * The language the [text] is in.
     */
    val language: String,
) : Comparable<Translation> {
    override fun compareTo(other: Translation): Int = language.compareTo(other.language)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Translation

        if (language != other.language) return false

        return true
    }

    override fun hashCode(): Int {
        return language.hashCode()
    }
}