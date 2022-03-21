package com.bselzer.gw2.v2.client.unit

import com.bselzer.gw2.v2.client.model.Token
import com.bselzer.gw2.v2.model.backstory.answer.BackstoryAnswerId
import com.bselzer.gw2.v2.model.character.CharacterName
import io.ktor.client.engine.mock.*
import org.junit.Test
import kotlin.test.assertEquals

class CharacterTests : BaseUnitTests() {
    override fun createEngineConfig(): MockEngineConfig.() -> Unit = {
        exhaust(url = "https://api.guildwars2.com/v2/characters/John Doe/backstory", content = "{ \"backstory\": [\"1-45\", \"180-99\", \"78-79\"] }")
    }

    /**
     * Verifies that the character backstory endpoint is being called and the response is deserialized correctly.
     */
    @Test
    fun backstory() {
        // Act
        val ids = use { character.backstory(CharacterName("John Doe"), Token("TEST")) }

        // Assert
        assertEquals(listOf("1-45", "180-99", "78-79").map { BackstoryAnswerId(it) }, ids)
    }
}