package com.bselzer.gw2.v2.intl.translation

import com.bselzer.gw2.v2.intl.model.Translation
import com.bselzer.gw2.v2.model.continent.Continent
import com.bselzer.ktx.function.collection.addTo

class ContinentTranslator : Translator<Continent> {
    override fun texts(model: Continent): List<String> = listOf(model.name)

    override fun translations(default: Continent, translated: Continent, language: String) = buildList {
        Translation(
            default = default.name,
            translated = translated.name,
            language = language
        ).addTo(this)
    }
}