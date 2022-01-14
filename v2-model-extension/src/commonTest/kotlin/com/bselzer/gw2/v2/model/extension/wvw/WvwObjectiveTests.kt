package com.bselzer.gw2.v2.model.extension.wvw

import com.bselzer.gw2.v2.model.wvw.objective.WvwObjective
import com.bselzer.ktx.geometry.dimension.bi.position.Point2D
import org.junit.Test
import kotlin.test.assertEquals

class WvwObjectiveTests {
    @Test
    fun position() {
        // Arrange
        val coordinates = WvwObjective(coordinates = listOf(1.0, 2.0, 3.0))
        val onlyZCoordinates = WvwObjective(coordinates = listOf(0.0, 0.0, 9.0), labelCoordinates = listOf(1.1, 1.2))
        val labelCoordinates = WvwObjective(labelCoordinates = listOf(4.0, 5.0))

        // Act / Assert
        assertEquals(Point2D(1.0, 2.0), coordinates.position())
        assertEquals(Point2D(1.1, 1.2), onlyZCoordinates.position())
        assertEquals(Point2D(4.0, 5.0), labelCoordinates.position())
    }
}