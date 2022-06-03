package com.bselzer.gw2.v2.intl.translation

import com.bselzer.gw2.v2.intl.model.Translation
import com.bselzer.gw2.v2.model.guild.upgrade.GuildUpgrade
import com.bselzer.gw2.v2.model.guild.upgrade.cost.CollectibleUpgradeCost
import com.bselzer.gw2.v2.model.guild.upgrade.cost.ItemUpgradeCost
import com.bselzer.ktx.function.collection.addTo

class GuildUpgradeTranslator : Translator<GuildUpgrade> {
    override fun translations(default: GuildUpgrade, translated: GuildUpgrade, language: String) = buildList {
        Translation(
            default = default.name,
            translated = translated.name,
            language = language
        ).addTo(this)

        Translation(
            default = default.name,
            translated = translated.name,
            language = language
        ).addTo(this)

        default.costs.zip(translated.costs) { defaultCost, translatedCost ->
            when {
                defaultCost is CollectibleUpgradeCost && translatedCost is CollectibleUpgradeCost -> Translation(
                    default = defaultCost.name,
                    translated = translatedCost.name,
                    language = language
                ).addTo(this)
                defaultCost is ItemUpgradeCost && translatedCost is ItemUpgradeCost -> Translation(
                    default = defaultCost.name,
                    translated = translatedCost.name,
                    language = language
                ).addTo(this)
                else -> {}
            }
        }
    }
}