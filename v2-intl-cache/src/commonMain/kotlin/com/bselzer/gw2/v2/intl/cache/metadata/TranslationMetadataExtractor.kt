package com.bselzer.gw2.v2.intl.cache.metadata

import com.bselzer.gw2.v2.intl.model.Translation
import org.kodein.db.Options
import org.kodein.db.Value
import org.kodein.db.model.orm.Metadata
import org.kodein.db.model.orm.MetadataExtractor

/**
 * A metadata extractor for [Translation] models.
 */
class TranslationMetadataExtractor : MetadataExtractor {
    override fun extractMetadata(model: Any, vararg options: Options.Puts): Metadata? = when (model) {
        is Translation -> Metadata(model.id())
        else -> null
    }
}

/**
 * Creates an id using the default text and language of the translation.
 * @return the id
 */
fun Translation.id() = Value.of(default, language)