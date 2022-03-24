package com.bselzer.gw2.v2.chatlink

import com.bselzer.gw2.v2.model.map.MapId
import com.bselzer.gw2.v2.model.wvw.objective.WvwMapObjectiveId
import com.bselzer.gw2.v2.model.wvw.objective.WvwObjectiveId
import kotlin.test.Test
import kotlin.test.assertEquals

class WvwObjectiveLinkTests {
    private val chatLink = "[&DAYAAAAmAAAA]"
    private val objectiveId = WvwObjectiveId(6)
    private val mapId = MapId(38)
    private val mapObjectiveId = WvwMapObjectiveId(mapId, objectiveId)

    @Test
    fun encode() {
        // Arrange
        val link = WvwObjectiveLink(mapObjectiveId)

        // Act
        val output = link.encode()

        // Assert
        assertEquals(chatLink, output)
    }

    @Test
    fun decode() {
        // Arrange
        val link = WvwObjectiveLink()
        assertEquals(link.id.toString(), "0-0")

        // Act
        val output = link.apply {
            decode(chatLink)
        }

        // Assert
        assertEquals(objectiveId, output.id.objectiveId)
        assertEquals(mapId, output.id.mapId)
        assertEquals(mapObjectiveId, output.id)
    }

    @Test
    fun encodeMapObjectiveId() {
        // Arrange
        val link = WvwObjectiveLink(mapObjectiveId)

        // Act
        val output = link.encode()

        // Assert
        assertEquals(chatLink, output)
    }
}