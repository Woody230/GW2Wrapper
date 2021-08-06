package com.bselzer.library.gw2.v2.client.jvm.instrumented

import com.bselzer.library.gw2.v2.client.common.Gw2Client
import io.ktor.client.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test
import kotlin.test.assertTrue

class CharacterTests
{
    /**
     * Verifies that the character backstory endpoint is being called and the response is deserialized correctly.
     */
    @Test
    fun backstory()
    {
        // Arrange
        val httpClient = HttpClient()
        val gw2Client = Gw2Client(httpClient)

        val resource = this::class.java.getResource("/Data.json")!!.readText()
        val json = Json.decodeFromString<Map<String, String>>(resource)

        // Act
        val ids = runBlocking {
            gw2Client.use {
                it.character.backstory(json["characterName"].toString(), json["token"].toString())
            }
        }

        // Assert
        assertTrue(ids.isNotEmpty())
    }
}