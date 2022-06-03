package com.bselzer.gw2.v2.intl.translation

import com.bselzer.gw2.v2.intl.model.Translation
import com.bselzer.gw2.v2.model.wvw.upgrade.WvwUpgrade
import com.bselzer.ktx.function.collection.addTo

class WvwUpgradeTranslator : Translator<WvwUpgrade> {
    override fun translations(default: WvwUpgrade, translated: WvwUpgrade, language: String) = buildList {
        default.tiers.zip(translated.tiers) { defaultTier, translatedTier ->
            Translation(
                default = defaultTier.name,
                translated = translatedTier.name,
                language = language
            ).addTo(this)

            defaultTier.upgrades.zip(translatedTier.upgrades) { defaultUpgrade, translatedUpgrade ->
                Translation(
                    default = defaultUpgrade.name,
                    translated = translatedUpgrade.name,
                    language = language
                ).addTo(this)

                Translation(
                    default = defaultUpgrade.description,
                    translated = translatedUpgrade.description,
                    language = language
                ).addTo(this)
            }
        }
    }
}