package com.bselzer.library.gw2.v2.tile.extension

import com.bselzer.library.gw2.v2.model.continent.Continent
import com.bselzer.library.gw2.v2.tile.model.response.TileGrid
import com.bselzer.library.kotlin.extension.geometry.dimension.bi.position.Point
import kotlin.math.pow

/**
 * Scales the [Point] to the given [zoom] level within the bounds of the [grid].
 *
 * @return the scaled point
 */
fun Point.scale(grid: TileGrid, continent: Continent, zoom: Int): Point
{
    // Scale the coordinates to the current zoom level.
    val zoomWidth = 2.0.pow(zoom) * grid.tileWidth
    val zoomHeight = 2.0.pow(zoom) * grid.tileHeight
    val zoomX = zoomWidth * x / continent.continentDimensions.width
    val zoomY = zoomHeight * y / continent.continentDimensions.height

    // Remove the excluded starting tiles.
    val x = zoomX - (grid.startX * grid.tileWidth)
    val y = zoomY - (grid.startY * grid.tileHeight)
    return Point(x, y)
}