package com.bselzer.gw2.v2.intl.translation

import com.bselzer.gw2.v2.intl.model.Translations
import com.bselzer.gw2.v2.model.wvw.objective.WvwObjective
import com.bselzer.ktx.function.collection.addTo

class WvwObjectiveTranslator : Translator<WvwObjective> {
    override fun translations(default: WvwObjective, translated: WvwObjective, language: String) = buildList {
        Translations(
            default = default.name,
            translated = translated.name,
            language = language
        ).addTo(this)
    }
}