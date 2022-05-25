package com.bselzer.gw2.v2.intl.model

import kotlinx.serialization.Serializable

@Serializable
data class Translations(
    /**
     * The default text.
     */
    val default: String,

    /**
     * The name of the language mapped to the translated text.
     */
    val translations: Set<Translation>
) : Comparable<Translations> {
    constructor(default: String, translation: Translation) : this(default, setOf(translation))
    constructor(default: String, translated: String, language: String) : this(default, Translation(text = translated, language = language))

    override fun compareTo(other: Translations): Int {
        val comparison = default.compareTo(other.default)

        // Prioritize having more translations when the defaults match.
        return if (comparison != 0) comparison else translations.size.compareTo(other.translations.size)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Translations

        if (default != other.default) return false

        return true
    }

    override fun hashCode(): Int {
        return default.hashCode()
    }
}