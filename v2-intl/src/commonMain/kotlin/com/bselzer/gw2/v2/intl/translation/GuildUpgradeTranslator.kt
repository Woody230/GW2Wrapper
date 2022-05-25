package com.bselzer.gw2.v2.intl.translation

import com.bselzer.gw2.v2.intl.model.Translations
import com.bselzer.gw2.v2.model.guild.upgrade.GuildUpgrade
import com.bselzer.ktx.function.collection.addTo

class GuildUpgradeTranslator : Translator<GuildUpgrade> {
    override fun translations(default: GuildUpgrade, translated: GuildUpgrade, language: String) = buildList {
        Translations(
            default = default.name,
            translated = translated.name,
            language = language
        ).addTo(this)

        Translations(
            default = default.name,
            translated = translated.name,
            language = language
        ).addTo(this)

        // TODO cost translations
    }
}