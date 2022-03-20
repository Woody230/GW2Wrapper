package com.bselzer.gw2.v2.cache.metadata

import com.bselzer.gw2.v2.model.identifier.Identifiable
import org.kodein.db.Options
import org.kodein.db.model.orm.Metadata
import org.kodein.db.model.orm.MetadataExtractor

/**
 * A metadata extractor for [Identifiable] models.
 */
class IdentifiableMetadataExtractor : MetadataExtractor {
    override fun extractMetadata(model: Any, vararg options: Options.Puts): Metadata? = when (model) {
        is Identifiable<*> -> {
            val id = model.id.value
            if (id == null) null else Metadata(id)
        }
        else -> {
            null
        }
    }
}