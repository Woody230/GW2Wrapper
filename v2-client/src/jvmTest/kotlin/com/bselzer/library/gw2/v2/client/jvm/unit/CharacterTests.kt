package com.bselzer.library.gw2.v2.client.jvm.unit

import io.ktor.client.engine.mock.*
import org.junit.Test
import kotlin.test.assertEquals

class CharacterTests : BaseUnitTests()
{
    override fun createEngineConfig(): MockEngineConfig.() -> Unit = {
        exhaust(url = "https://api.guildwars2.com/v2/characters/John Doe/backstory", content = "{ \"backstory\": [\"1-45\", \"180-99\", \"78-79\"] }")
    }

    /**
     * Verifies that the character backstory endpoint is being called and the response is deserialized correctly.
     */
    @Test
    fun backstory()
    {
        // Act
        val ids = use { character.backstory("John Doe", "TEST") }

        // Assert
        assertEquals(listOf("1-45", "180-99", "78-79"), ids)
    }
}