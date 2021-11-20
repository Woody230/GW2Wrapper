package com.bselzer.library.gw2.v2.tile.model.request

import com.bselzer.library.gw2.v2.tile.model.response.TileGrid
import kotlinx.serialization.Serializable

/**
 * Represents a request for getting [TileGrid] content.
 */
@Serializable
data class TileGridRequest(
    /**
     * The starting horizontal tile position.
     */
    val startX: Int,

    /**
     * The ending horizontal tile position.
     */
    val endX: Int,

    /**
     * The starting vertical tile position.
     */
    val startY: Int,

    /**
     * The ending vertical tile position.
     */
    val endY: Int,

    /**
     * The width of each individual tile.
     */
    val tileWidth: Int,

    /**
     * The height of each individual tile.
     */
    val tileHeight: Int,

    /**
     * The width of the texture.
     */
    val textureWidth: Int,

    /**
     * The height of the texture.
     */
    val textureHeight: Int,

    /**
     * The zoom level.
     */
    val zoom: Int,

    /**
     * The requests for tiles.
     */
    val tileRequests: List<TileRequest>,
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
        tileRequests = tileRequests.filter { tileRequest -> tileRequest.gridX in startX..endX && tileRequest.gridY in startY..endY }
    )
}