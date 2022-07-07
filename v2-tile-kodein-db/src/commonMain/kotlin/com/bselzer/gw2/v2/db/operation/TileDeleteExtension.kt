package com.bselzer.gw2.v2.db.operation

import com.bselzer.gw2.v2.model.tile.request.TileGridRequest
import com.bselzer.gw2.v2.model.tile.request.TileRequest
import com.bselzer.gw2.v2.model.tile.response.Tile
import com.bselzer.gw2.v2.model.tile.response.TileGrid
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