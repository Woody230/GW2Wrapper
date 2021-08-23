package com.bselzer.library.gw2.v2.client.instrumented

import org.junit.Test
import kotlin.test.assertTrue

class CharacterTests : BaseInstrumentedTests()
{
    /**
     * Verifies that the character backstory endpoint is being called and the response is deserialized correctly.
     */
    @Test
    fun backstory()
    {
        // Act
        val ids = use { character.backstory(secrets.characterName(), secrets.token()) }

        // Assert
        assertTrue(ids.isNotEmpty())
    }
}