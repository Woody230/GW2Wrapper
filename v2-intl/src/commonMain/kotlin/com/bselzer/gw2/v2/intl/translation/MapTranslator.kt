package com.bselzer.gw2.v2.intl.translation

import com.bselzer.gw2.v2.intl.model.Translations
import com.bselzer.gw2.v2.model.map.Map
import com.bselzer.ktx.function.collection.addTo

class MapTranslator : Translator<Map> {
    override fun translations(default: Map, translated: Map, language: String) = buildList {
        Translations(
            default = default.name,
            translated = translated.name,
            language = language
        ).addTo(this)
    }
}