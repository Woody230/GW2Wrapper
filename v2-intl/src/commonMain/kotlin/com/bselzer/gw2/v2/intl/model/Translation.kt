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
) : Comparable<Translation> {
    override fun compareTo(other: Translation): Int = translated.compareTo(other.translated)
}