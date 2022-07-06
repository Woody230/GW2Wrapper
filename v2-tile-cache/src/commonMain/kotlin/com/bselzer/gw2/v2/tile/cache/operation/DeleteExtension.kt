package com.bselzer.gw2.v2.tile.cache.operation

import com.bselzer.gw2.v2.tile.model.request.TileGridRequest
import com.bselzer.gw2.v2.tile.model.request.TileRequest
import com.bselzer.gw2.v2.tile.model.response.Tile
import com.bselzer.gw2.v2.tile.model.response.TileGrid
import com.bselzer.ktx.db.operation.clear
import com.bselzer.ktx.db.transaction.Transaction

/**
 * Clears the [Tile] and [TileGrid] models.
 */
fun Transaction.clearTile() {
    clear<Tile>()
    clear<TileGrid>()
    clear<TileRequest>()
    clear<TileGridRequest>()
}