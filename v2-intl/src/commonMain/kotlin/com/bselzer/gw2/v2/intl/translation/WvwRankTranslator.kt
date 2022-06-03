package com.bselzer.gw2.v2.intl.translation

import com.bselzer.gw2.v2.intl.model.Translation
import com.bselzer.gw2.v2.model.wvw.rank.WvwRank
import com.bselzer.ktx.function.collection.addTo

class WvwRankTranslator : Translator<WvwRank> {
    override fun texts(model: WvwRank): List<String> = listOf(model.title)

    override fun translations(default: WvwRank, translated: WvwRank, language: String) = buildList {
        Translation(
            default = default.title,
            translated = translated.title,
            language = language
        ).addTo(this)
    }
}