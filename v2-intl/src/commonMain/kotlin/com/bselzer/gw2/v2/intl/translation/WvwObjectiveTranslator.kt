package com.bselzer.gw2.v2.intl.translation

import com.bselzer.gw2.v2.intl.model.Translation
import com.bselzer.gw2.v2.model.wvw.objective.WvwObjective
import com.bselzer.ktx.function.collection.addTo

class WvwObjectiveTranslator : Translator<WvwObjective> {
    override fun text(model: WvwObjective): List<String> = listOf(model.name)

    override fun translations(default: WvwObjective, translated: WvwObjective, language: String) = buildList {
        Translation(
            default = default.name,
            translated = translated.name,
            language = language
        ).addTo(this)
    }
}