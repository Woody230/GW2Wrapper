package com.bselzer.library.gw2.v2.client.jvm.unit

import asHeader
import com.bselzer.library.gw2.v2.client.common.client.Gw2Client
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class AchievementTests
{
    /**
     * Verifies that the achievement ids endpoint is being called and the response is deserialized correctly.
     */
    @Test
    fun achievementIds()
    {
        // Arrange
        val httpClient = HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.toString())
                    {
                        "https://api.guildwars2.com/v2/achievements" -> respond("[1, 614, 1024, 29]", headers = ContentType.Application.Json.asHeader())
                        else -> error("Cannot handle ${request.url.fullPath}")
                    }
                }
            }
        }

        val gw2Client = Gw2Client(httpClient)

        // Act
        val ids = runBlocking {
            gw2Client.use {
                it.achievement.ids()
            }
        }

        // Assert
        assertEquals(listOf(1, 614, 1024, 29), ids)
    }
}