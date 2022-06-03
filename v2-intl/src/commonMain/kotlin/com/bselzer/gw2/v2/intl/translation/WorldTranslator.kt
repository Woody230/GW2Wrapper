package com.bselzer.gw2.v2.intl.translation

import com.bselzer.gw2.v2.intl.model.Translation
import com.bselzer.gw2.v2.model.world.World
import com.bselzer.ktx.function.collection.addTo

class WorldTranslator : Translator<World> {
    override fun texts(model: World): List<String> = listOf(model.name.value)

    override fun translations(default: World, translated: World, language: String): List<Translation> = buildList {
        Translation(
            default.name.value,
            translated.name.value,
            language
        ).addTo(this)
    }
}