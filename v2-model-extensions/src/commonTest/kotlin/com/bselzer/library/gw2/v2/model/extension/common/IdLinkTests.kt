package com.bselzer.library.gw2.v2.model.extension.common

import com.bselzer.library.gw2.v2.model.extension.common.chatlink.IdLink
import org.junit.Test
import kotlin.test.assertEquals

abstract class IdLinkTests<Link> : ChatLinkTests<Link>() where Link : IdLink
{
    /**
     * The mapping of a chat link to the id.
     */
    abstract val mapping: Map<String, Int>

    @Test
    fun encode()
    {
        for (input in mapping)
        {
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
    fun decode()
    {
        for (input in mapping)
        {
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