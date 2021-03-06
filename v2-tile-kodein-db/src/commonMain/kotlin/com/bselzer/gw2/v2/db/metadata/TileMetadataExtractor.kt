package com.bselzer.gw2.v2.db.metadata

import com.bselzer.gw2.v2.model.tile.request.TileRequest
import com.bselzer.gw2.v2.model.tile.response.Tile
import org.kodein.db.Options
import org.kodein.db.Value
import org.kodein.db.model.orm.Metadata
import org.kodein.db.model.orm.MetadataExtractor

/**
 * A metadata extractor for [Tile] models.
 */
class TileMetadataExtractor : MetadataExtractor {
    override fun extractMetadata(model: Any, vararg options: Options.Puts): Metadata? = when (model) {
        is Tile -> {
            Metadata(model.id())
        }
        else -> {
            null
        }
    }
}

/**
 * Creates an id using the zoom and position of the tile.
 * @return the id
 */
fun Tile.id() = Value.of(zoom, gridPosition.x, gridPosition.y)

/**
 * Creates an id using the zoom and posit`ion of the tile.
 * @return the id
 */
fun TileRequest.id() = Value.of(zoom, gridPosition.x, gridPosition.y)