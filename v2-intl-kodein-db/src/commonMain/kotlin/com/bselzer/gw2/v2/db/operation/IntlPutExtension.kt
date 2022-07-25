package com.bselzer.gw2.v2.db.operation

import com.bselzer.gw2.v2.intl.model.Translation
import com.bselzer.gw2.v2.intl.translation.Translator
import com.bselzer.ktx.db.transaction.Transaction
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import org.kodein.db.getById

/**
 * Finds missing translations from the [defaults] models and puts them in the database.
 *
 * Note that the batch **MUST** be written before you attempt to find the translations.
 * Consequently, the result of this method should be used instead if you do not want to immediately commit.
 *
 * @param translator the translator for retrieving translations
 * @param defaults the models with default text
 * @param language the language to request translations for
 * @param requestTranslated a block for retrieving a map of the default model to the translated model
 * @return the default text mapped to the translated text
 */
suspend fun <Model : Identifiable<Id, Value>, Id : Identifier<Value>, Value> Transaction.putMissingTranslations(
    translator: Translator<Model>,
    defaults: Collection<Model>,
    language: Language,
    requestTranslated: suspend (Collection<Id>, Language) -> Collection<Model>
): Map<String, String> {
    val defaultToTranslation = mutableMapOf<String, String>()

    // Find all the translations currently being stored.
    val texts = defaults.associateWith { default -> translator.texts(default) }
    val translations: Map<Model, List<Translation>> = texts.mapValues { model ->
        model.value.mapNotNull { default ->
            val id = org.kodein.db.Value.of(default, language.value)
            getById<Translation>(id)?.also { translation ->
                defaultToTranslation[default] = translation.translated
            }
        }
    }

    // If we are missing one of the translations, then we will need to make a request for the translations associated with the model.
    val missing = texts.filter { model ->
        val translation = translations[model.key] ?: emptyList()
        translation.size < model.value.size
    }

    if (missing.isNotEmpty()) {
        val translated = requestTranslated(missing.keys.map { default -> default.id }, language).associateBy { translated -> translated.id }
        missing.keys.associateWith { default -> translated[default.id] }.forEach { (default, translated) ->
            if (translated != null) {
                translator.translations(default = default, translated = translated, language = language.value).forEach { translation ->
                    defaultToTranslation[translation.default] = translation.translated
                    put(translation)
                }
            }
        }
    }

    return defaultToTranslation
}