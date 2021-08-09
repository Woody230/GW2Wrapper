package com.bselzer.library.gw2.v2.client.jvm.instrumented

import com.bselzer.library.gw2.v2.client.common.client.Gw2Client
import io.ktor.client.*
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertTrue

class AchievementTests
{
    /**
     * Verifies that the achievement ids endpoint is being called and the response is deserialized correctly.
     */
    @Test
    fun achievementIds()
    {
        // Arrange
        val httpClient = HttpClient()
        val gw2Client = Gw2Client(httpClient)

        // Act
        val ids = runBlocking {
            gw2Client.use {
                it.achievement.ids()
            }
        }

        // Assert
        assertTrue(ids.isNotEmpty())
    }
}