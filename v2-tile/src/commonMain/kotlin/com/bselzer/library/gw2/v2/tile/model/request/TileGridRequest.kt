package com.bselzer.library.gw2.v2.tile.model.request

import com.bselzer.library.gw2.v2.tile.model.response.TileGrid

/**
 * Represents a request for getting [TileGrid] content.
 */
data class TileGridRequest(
    /**
     * The starting horizontal tile position.
     */
    val startX: Int = 0,

    /**
     * The ending horizontal tile position.
     */
    val endX: Int = 0,

    /**
     * The starting vertical tile position.
     */
    val startY: Int = 0,

    /**
     * The ending vertical tile position.
     */
    val endY: Int = 0,

    /**
     * The width of each individual tile.
     */
    val tileWidth: Int = 0,

    /**
     * The height of each individual tile.
     */
    val tileHeight: Int = 0,

    /**
     * The requests for tiles.
     */
    val tileRequests: List<TileRequest> = emptyList(),
) {
    /**
     * Note that only existing [tileRequests] are used to form the bound.
     *
     * @return a request with existing tiles clamped by the given bounds
     */
    fun bounded(startX: Int = this.startX, endX: Int = this.endX, startY: Int = this.startY, endY: Int = this.endY): TileGridRequest = copy(
        startX = startX,
        endX = endX,
        startY = startY,
        endY = endY,
        tileRequests = tileRequests.filter { tileRequest -> tileRequest.x in startX..endX && tileRequest.y in startY..endY }
    )
}