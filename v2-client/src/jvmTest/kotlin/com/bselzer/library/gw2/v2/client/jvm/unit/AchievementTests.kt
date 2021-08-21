package com.bselzer.library.gw2.v2.client.jvm.unit

import io.ktor.client.engine.mock.*
import kotlin.test.Test
import kotlin.test.assertEquals

class AchievementTests : BaseUnitTests()
{
    override fun createEngineConfig(): MockEngineConfig.() -> Unit = {
        exhaust(url = "https://api.guildwars2.com/v2/achievements", content = "[1, 614, 1024, 29]")
    }

    /**
     * Verifies that the achievement ids endpoint is being called and the response is deserialized correctly.
     */
    @Test
    fun achievementIds()
    {
        // Act
        val ids = use { achievement.ids() }

        // Assert
        assertEquals(listOf(1, 614, 1024, 29), ids)
    }
}