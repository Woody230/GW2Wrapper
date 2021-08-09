package com.bselzer.library.gw2.v2.client.jvm.unit

import asHeader
import com.bselzer.library.gw2.v2.client.common.client.Gw2Client
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

class CharacterTests
{
    /**
     * Verifies that the character backstory endpoint is being called and the response is deserialized correctly.
     */
    @Test
    fun backstory()
    {
        // Arrange
        val httpClient = HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.toString())
                    {
                        "https://api.guildwars2.com/v2/characters/John Doe/backstory" -> respond(
                            "[\"1-45\", \"180-99\", \"78-79\"]",
                            headers = ContentType.Application.Json.asHeader()
                        )
                        else -> error("Cannot handle ${request.url.fullPath}")
                    }
                }
            }
        }

        val gw2Client = Gw2Client(httpClient)

        // Act
        val ids = runBlocking {
            gw2Client.use {
                it.character.backstory("John Doe", "")
            }
        }

        // Assert
        assertEquals(listOf("1-45", "180-99", "78-79"), ids)
    }
}