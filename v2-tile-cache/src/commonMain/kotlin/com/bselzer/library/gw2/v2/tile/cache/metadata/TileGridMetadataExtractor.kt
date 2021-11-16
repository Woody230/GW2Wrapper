package com.bselzer.library.gw2.v2.tile.cache.metadata

import com.bselzer.library.gw2.v2.tile.model.request.TileGridRequest
import com.bselzer.library.gw2.v2.tile.model.response.TileGrid
import org.kodein.db.Options
import org.kodein.db.model.orm.Metadata
import org.kodein.db.model.orm.MetadataExtractor

/**
 * A metadata extractor for [TileGrid] models.
 */
class TileGridMetadataExtractor : MetadataExtractor {
    override fun extractMetadata(model: Any, vararg options: Options.Puts): Metadata? = when (model) {
        is TileGrid -> {
            Metadata(model.id())
        }
        else -> {
            null
        }
    }
}

/**
 * Creates an id using the zoom and bounds of the grid.
 * @return the id
 */
fun TileGrid.id() = listOf(zoom, startX, startY, endX, endY)

/**
 * Creates an id using the zoom and bounds of the grid.
 * @return the id
 */
fun TileGridRequest.id() = listOf(zoom, startX, startY, endX, endY)