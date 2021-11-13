package com.bselzer.library.gw2.v2.tile.extension

import com.bselzer.library.gw2.v2.model.continent.Continent
import com.bselzer.library.gw2.v2.tile.model.response.TileGrid
import com.bselzer.library.kotlin.extension.geometry.dimension.bi.position.Point2D
import kotlin.math.pow

/**
 * Scales the [Point2D] to the given [zoom] level within the bounds of the [grid].
 *
 * @return the scaled point
 */
fun Point2D.scale(grid: TileGrid, continent: Continent, zoom: Int): Point2D
{
    // Scale the coordinates to the current zoom level.
    val zoomWidth = 2.0.pow(zoom) * grid.tileWidth
    val zoomHeight = 2.0.pow(zoom) * grid.tileHeight
    val zoomX = zoomWidth * x / continent.dimensions.width
    val zoomY = zoomHeight * y / continent.dimensions.height

    // Remove the excluded starting tiles.
    val x = zoomX - (grid.startX * grid.tileWidth)
    val y = zoomY - (grid.startY * grid.tileHeight)
    return Point2D(x, y)
}