package com.bselzer.gw2.v2.tile.image

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import com.bselzer.gw2.v2.model.continent.Continent
import com.bselzer.gw2.v2.model.continent.floor.Floor
import com.bselzer.gw2.v2.tile.client.TileClient
import com.bselzer.gw2.v2.tile.model.response.TileGrid
import kotlinx.coroutines.coroutineScope
import java.io.File
import java.io.FileOutputStream

class ImageGenerator(
    private val tile: TileClient = TileClient(),
) {
    /**
     * Constructs the map at each zoom level and outputs each image as a PNG file in the [outputDirectory].
     *
     * @param outputDirectory where to store the images
     * @param continent the continent
     * @param floor the floor within the [continent]
     */
    suspend fun generateMap(continent: Continent, floor: Floor, outputDirectory: String) = coroutineScope {
        for (zoom in continent.minZoom..continent.maxZoom) {
            val grid = tile.grid(continent, floor, zoom)
            generateMap(outputDirectory, "Map$zoom", grid)
        }
    }

    /**
     * Constructs the map bitmap and outputs it as a PNG file in the [outputDirectory].
     *
     * @param outputDirectory where to store the image
     * @param fileName the name of the image file, excluding the extension
     * @param grid the tiled map grid
     */
    fun generateMap(outputDirectory: String, fileName: String = "Map", grid: TileGrid) {
        val map = Bitmap.createBitmap(grid.width, grid.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(map)
        grid.rows.forEachIndexed { y, row ->
            row.forEachIndexed { x, tile ->
                val bitmap = BitmapFactory.decodeByteArray(tile.content, 0, tile.content.size)
                    ?: throw NullPointerException("Missing content for the tile [${tile.gridX},${tile.gridY}].")
                canvas.drawBitmap(bitmap, (grid.tileWidth * x).toFloat(), (grid.tileHeight * y).toFloat(), null)
            }
        }

        val file = File("$outputDirectory/$fileName.png")
        val stream = FileOutputStream(file)
        map.compress(Bitmap.CompressFormat.PNG, 100, stream)
        stream.close()
    }
}