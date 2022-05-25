package com.bselzer.gw2.v2.intl.translation

import com.bselzer.gw2.v2.intl.model.Translations
import com.bselzer.gw2.v2.model.wvw.ability.WvwAbility
import com.bselzer.ktx.function.collection.addTo

class WvwAbilityTranslator : Translator<WvwAbility> {
    override fun translations(default: WvwAbility, translated: WvwAbility, language: String) = buildList {
        Translations(
            default = default.name,
            translated = translated.name,
            language = language
        ).addTo(this)

        Translations(
            default = default.description,
            translated = translated.description,
            language = language
        ).addTo(this)

        default.ranks.zip(translated.ranks) { defaultRank, translatedRank ->
            Translations(
                default = defaultRank.effect,
                translated = translatedRank.effect,
                language = language
            ).addTo(this)
        }
    }
}