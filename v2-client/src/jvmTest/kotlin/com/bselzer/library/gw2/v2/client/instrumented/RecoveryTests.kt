package com.bselzer.library.gw2.v2.client.instrumented

import org.junit.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class RecoveryTests : BaseInstrumentedTests() {
    /**
     * Verifies that a singleById call can be recovered.
     */
    @Test
    fun getSingleById() {
        // Arrange
        val id = -1

        // Act / Assert
        testRecovery({ achievement.achievement(id) }) { result ->
            // Result should be defaulted, except for the id.
            assertEquals(id, result.id)
            assertEquals("", result.iconLink)
            assertEquals(0, result.pointCap)
            assertContentEquals(emptyList(), result.tiers)
        }
    }

    /**
     * Verifies that a chunkedIds call can be recovered.
     */
    @Test
    fun chunkedIds() {
        // Arrange
        val id = -1

        // Act / Assert
        testRecovery({ achievement.achievements(listOf(id)) }) { results ->
            assertEquals(1, results.size)
            assertEquals(id, results.single().id)
        }
    }
}