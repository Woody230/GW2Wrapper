package com.bselzer.gw2.v2.intl.translation

import com.bselzer.gw2.v2.intl.model.Translation
import com.bselzer.gw2.v2.model.wvw.ability.WvwAbility
import com.bselzer.ktx.function.collection.addTo

class WvwAbilityTranslator : Translator<WvwAbility> {
    override fun text(model: WvwAbility): List<String> = buildList {
        add(model.name)
        add(model.description)
        model.ranks.forEach { rank -> add(rank.effect) }
    }

    override fun translations(default: WvwAbility, translated: WvwAbility, language: String) = buildList {
        Translation(
            default = default.name,
            translated = translated.name,
            language = language
        ).addTo(this)

        Translation(
            default = default.description,
            translated = translated.description,
            language = language
        ).addTo(this)

        default.ranks.zip(translated.ranks) { defaultRank, translatedRank ->
            Translation(
                default = defaultRank.effect,
                translated = translatedRank.effect,
                language = language
            ).addTo(this)
        }
    }
}