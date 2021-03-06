package com.bselzer.gw2.v2.intl.translation

import com.bselzer.gw2.v2.intl.model.Translation
import com.bselzer.gw2.v2.model.map.Map
import com.bselzer.ktx.function.collection.addTo

class MapTranslator : Translator<Map> {
    override fun texts(model: Map): List<String> = listOf(model.name)

    override fun translations(default: Map, translated: Map, language: String) = buildList {
        Translation(
            default = default.name,
            translated = translated.name,
            language = language
        ).addTo(this)
    }
}