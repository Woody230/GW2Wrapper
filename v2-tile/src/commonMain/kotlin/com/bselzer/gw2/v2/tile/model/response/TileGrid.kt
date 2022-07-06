package com.bselzer.gw2.v2.tile.model.response

import com.bselzer.gw2.v2.tile.model.position.*
import com.bselzer.gw2.v2.tile.model.request.TileGridRequest
import com.bselzer.ktx.geometry.dimension.bi.Dimension2D
import com.bselzer.ktx.geometry.dimension.bi.position.Point2D
import com.bselzer.ktx.serialization.serializer.Dimension2DSerializer
import kotlinx.serialization.Serializable
import kotlin.math.pow

/**
 * The tiles within the grid.
 */
@Serializable
data class TileGrid(
    /**
     * The size of each individual tile.
     */
    @Serializable(with = Dimension2DSerializer::class)
    val tileSize: Dimension2D = Dimension2D(),

    /**
     * The full dimensions of the texture, equivalent to the size at the max zoom level.
     */
    @Serializable(with = Dimension2DSerializer::class)
    val textureSize: Dimension2D = Dimension2D(),

    /**
     * The starting coordinates of the bound, representing the top left corner of the rectangle.
     */
    val topLeft: GridPosition = GridPosition(0, 0),

    /**
     * The ending coordinates of the bound, representing the bottom right corner of the rectangle.
     */
    val bottomRight: GridPosition = GridPosition(0, 0),

    /**
     * The zoom level.
     */
    val zoom: Int = 0,

    /**
     * The subset of tiles with content.
     */
    val tiles: List<Tile> = emptyList(),
) {
    /**
     * All of the tiles within the boundary by rows.
     */
    val rows: List<List<Tile>> = createRows()

    /**
     * All of the tiles within the boundary by columns.
     */
    val columns: List<List<Tile>> = createColumns()

    /**
     * The size of the grid within the bounds of the [topLeft] and [bottomRight] coordinates.
     */
    @Serializable(with = Dimension2DSerializer::class)
    val size: Dimension2D = Dimension2D(
        width = columns.size * tileSize.width,
        height = rows.size * tileSize.height
    )

    /**
     * Creates a new instance using the data from the [request].
     */
    constructor(
        request: TileGridRequest,
        tiles: List<Tile> = emptyList()
    ) : this(
        tileSize = request.tileSize,
        textureSize = request.textureSize,
        topLeft = request.topLeft,
        bottomRight = request.bottomRight,
        zoom = request.zoom,
        tiles = tiles
    )

    /**
     * @return the tile at the relative [position] within the [zoom] level, or null if it does not exist
     */
    fun getTileOrNull(position: GridPosition, zoom: Int): Tile? = tiles.firstOrNull { tile -> tile.gridPosition == position && tile.zoom == zoom }

    /**
     * @return the tile at the relative [position] within the [zoom] level, or a tile with empty content if it does not exist
     */
    fun getTileOrDefault(position: GridPosition, zoom: Int): Tile = getTileOrNull(position, zoom) ?: Tile(
        gridPosition = position,
        zoom = zoom,
        size = tileSize,
    )

    /**
     * Normalizes the [position] to a range of 0 to 1 within the bounds of the grid.
     *
     * @see bounded
     */
    fun normalize(position: BoundedPosition): NormalizedPosition = NormalizedPosition(
        value = Point2D(
            x = position.x / size.width,
            y = position.y / size.height
        )
    )

    /**
     * Scales the [position] from the dimensions at the max zoom level to the grid's [zoom] level.
     */
    fun scaled(position: TexturePosition): ScaledPosition {
        val zoomWidth = 2.0.pow(zoom) * tileSize.width
        val zoomHeight = 2.0.pow(zoom) * tileSize.height
        val zoomX = zoomWidth * position.x / textureSize.width
        val zoomY = zoomHeight * position.y / textureSize.height
        return ScaledPosition(
            value = Point2D(x = zoomX, y = zoomY)
        )
    }

    /**
     * Scales the [position] from the dimensions at the max zoom level to the grid's [zoom] level with the origin changed to [topLeft].
     */
    fun bounded(position: TexturePosition): BoundedPosition = bounded(scaled(position))

    /**
     * Adjusts the [position] such that the origin becomes the [topLeft] coordinates.
     */
    fun bounded(position: ScaledPosition): BoundedPosition {
        // Remove the excluded starting tiles.
        val boundedX = position.x - (topLeft.x * tileSize.width)
        val boundedY = position.y - (topLeft.y * tileSize.height)
        return BoundedPosition(
            value = Point2D(x = boundedX, y = boundedY)
        )
    }

    /**
     * Creates the grid, organized by the rows. Missing tiles are created with empty content.
     */
    private fun createRows(): List<List<Tile>> {
        val grouped = tiles.groupBy { tile -> tile.gridPosition.y }
        val grid = mutableListOf<List<Tile>>()

        for (y in topLeft.y..bottomRight.y) {
            val group = grouped[y] ?: emptyList()

            val row = (topLeft.x..bottomRight.x).map { x ->
                group.firstOrNull { tile -> tile.gridPosition.x == x } ?: Tile(
                    gridPosition = GridPosition(x = x, y = y),
                    size = tileSize,
                    zoom = zoom
                )
            }

            grid.add(row)
        }

        return grid
    }

    /**
     * Creates the grid, organized by the columns. Missing tiles are created with empty content.
     */
    private fun createColumns(): List<List<Tile>> {
        val grouped = tiles.groupBy { tile -> tile.gridPosition.x }
        val grid = mutableListOf<List<Tile>>()

        for (y in topLeft.x..bottomRight.x) {
            val group = grouped[y] ?: emptyList()

            val column = (topLeft.y..bottomRight.y).map { x ->
                group.firstOrNull { tile -> tile.gridPosition.y == y } ?: Tile(
                    gridPosition = GridPosition(x = x, y = y),
                    size = tileSize,
                    zoom = zoom
                )
            }

            grid.add(column)
        }

        return grid
    }
}