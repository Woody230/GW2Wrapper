package com.bselzer.gw2.v2.intl.translation

import com.bselzer.gw2.v2.intl.model.Translations
import com.bselzer.gw2.v2.model.continent.Continent
import com.bselzer.ktx.function.collection.addTo

class ContinentTranslator : Translator<Continent> {
    override fun translations(default: Continent, translated: Continent, language: String) = buildList {
        Translations(
            default = default.name,
            translated = translated.name,
            language = language
        ).addTo(this)
    }
}