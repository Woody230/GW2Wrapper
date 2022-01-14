package com.bselzer.gw2.v2.client.instrumented

import org.junit.Test
import kotlin.test.assertTrue

class AchievementTests : BaseInstrumentedTests() {
    /**
     * Verifies that the achievement ids endpoint is being called and the response is deserialized correctly.
     */
    @Test
    fun achievementIds() {
        // Act
        val ids = use { achievement.ids() }

        // Assert
        assertTrue(ids.isNotEmpty())
    }
}