package com.bselzer.gw2.v2.chatlink

import kotlin.test.Test
import kotlin.test.assertEquals

abstract class IdLinkTests<Link> : ChatLinkTests<Link>() where Link : IdLink {
    /**
     * The mapping of a chat link to the id.
     */
    abstract val mapping: Map<String, Int>

    @Test
    fun encode() {
        for (input in mapping) {
            // Arrange
            val link = input.key
            instance.id = input.value

            // Act
            val output = instance.encode()

            // Assert
            assertEquals(link, output)
        }
    }

    @Test
    fun decode() {
        for (input in mapping) {
            // Arrange
            val link = input.key
            val id = input.value

            // Act
            val output = decode(link)

            // Assert
            assertEquals(id, output.id)
        }
    }
}