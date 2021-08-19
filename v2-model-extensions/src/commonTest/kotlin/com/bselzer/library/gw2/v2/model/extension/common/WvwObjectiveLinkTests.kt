package com.bselzer.library.gw2.v2.model.extension.common

import com.bselzer.library.gw2.v2.model.extension.common.chatlink.WvwObjectiveLink
import org.junit.Test
import kotlin.test.assertEquals

class WvwObjectiveLinkTests
{
    private val chatLink = "[&DAYAAAAmAAAA]"
    private val objectiveId = 6
    private val mapId = 38
    private val mapObjectiveId = "38-6"

    @Test
    fun encode()
    {
        // Arrange
        val link = WvwObjectiveLink(objectiveId = objectiveId, mapId = mapId)

        // Act
        val output = link.encode()

        // Assert
        assertEquals(chatLink, output)
    }

    @Test
    fun decode()
    {
        // Arrange
        val link = WvwObjectiveLink()
        assertEquals(link.mapObjectiveId, "0-0")

        // Act
        val output = link.apply {
            decode(chatLink)
        }

        // Assert
        assertEquals(objectiveId, output.objectiveId)
        assertEquals(mapId, output.mapId)
        assertEquals(mapObjectiveId, output.mapObjectiveId)
    }

    @Test
    fun encodeMapObjectiveId()
    {
        // Arrange
        val link = WvwObjectiveLink(mapObjectiveId = mapObjectiveId)

        // Act
        val output = link.encode()

        // Assert
        assertEquals(chatLink, output)
    }
}