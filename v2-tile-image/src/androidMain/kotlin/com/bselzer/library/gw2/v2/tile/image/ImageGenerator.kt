package com.bselzer.library.gw2.v2.tile.image

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import com.bselzer.library.gw2.v2.client.client.Gw2Client
import com.bselzer.library.gw2.v2.tile.client.TileClient
import com.bselzer.library.gw2.v2.tile.model.response.TileGrid
import kotlinx.coroutines.coroutineScope
import java.io.File
import java.io.FileOutputStream

class ImageGenerator(
    private val gw2: Gw2Client = Gw2Client(),
    private val tile: TileClient = TileClient(),
) {
    private companion object {
        const val WVW_CONTINENT = 2
        const val WVW_FLOOR = 3
    }

    /**
     * Constructs the WvW map at each zoom level and outputs each image as a PNG file in the [outputDirectory].
     *
     * @param outputDirectory where to store the images
     */
    suspend fun generateWvwMap(outputDirectory: String) = coroutineScope {
        val continent = gw2.continent.continent(WVW_CONTINENT)
        val floor = gw2.continent.floor(WVW_CONTINENT, WVW_FLOOR)
        for (zoom in continent.minZoom..continent.maxZoom) {
            val grid = tile.grid(continent, floor, zoom)
            generateWvwMap(outputDirectory, "WvwMap$zoom", grid)
        }
    }

    /**
     * Constructs the WvW map bitmap and outputs it as a PNG file in the [outputDirectory].
     *
     * @param outputDirectory where to store the image
     * @param fileName the name of the image file, excluding the extension
     * @param grid the tiled map grid
     */
    fun generateWvwMap(outputDirectory: String, fileName: String = "WvwMap", grid: TileGrid) {
        val map = Bitmap.createBitmap(grid.width, grid.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(map)
        grid.grid.forEachIndexed { y, row ->
            row.forEachIndexed { x, tile ->
                val bitmap = BitmapFactory.decodeByteArray(tile.content, 0, tile.content.size)
                    ?: throw NullPointerException("Missing content for the tile [${tile.x},${tile.y}].")
                canvas.drawBitmap(bitmap, (grid.tileWidth * x).toFloat(), (grid.tileHeight * y).toFloat(), null)
            }
        }

        val file = File("$outputDirectory/$fileName.png")
        val stream = FileOutputStream(file)
        map.compress(Bitmap.CompressFormat.PNG, 100, stream)
        stream.close()
    }
}