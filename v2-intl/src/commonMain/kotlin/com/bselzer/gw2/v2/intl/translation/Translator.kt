package com.bselzer.gw2.v2.intl.translation

import com.bselzer.gw2.v2.intl.model.Translation

interface Translator<Model> {
    // TODO more effective way of declaring translations to reduce verbosity (delegate on properties, language scope) -- DSL?

    /**
     * Creates the translations for the text found in the [default] model to the text found in the [translated] model in the given [language].
     */
    fun translations(default: Model, translated: Model, language: String): List<Translation>
}