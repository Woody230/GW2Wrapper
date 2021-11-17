package com.bselzer.library.gw2.v2.client.unit

import com.bselzer.library.gw2.v2.model.character.Character
import io.ktor.client.engine.mock.*
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class RecoveryTests : BaseUnitTests() {
    override fun createEngineConfig(): MockEngineConfig.() -> Unit = { throwError() }

    /**
     * Verifies that a getList call can be recovered.
     */
    @Test
    fun getList() = testRecovery({ profession.ids() }) { results ->
        assertEquals(0, results.size)
    }

    /**
     * Verifies that an allIds call can be recovered.
     */
    @Test
    fun allIds() = testRecovery({ profession.professions() }) { results ->
        assertEquals(0, results.size)
    }

    /**
     * Verifies that an allTabs call can be recovered.
     */
    @Test
    fun allTabs() = testRecovery({ character.buildTabs("") }) { results ->
        assertEquals(0, results.size)
    }

    /**
     * Verifies that a getSingle call can be recovered.
     */
    @Test
    fun getSingle() = testRecovery({ achievement.dailiesForToday() }) { result ->
        assertContentEquals(emptyList(), result.fractals)
        assertContentEquals(emptyList(), result.wvw)
    }

    /**
     * Verifies that a getIdentifiableSingle call can be recovered.
     */
    @Test
    fun getIdentifiableSingle() = testRecovery({ guild.guild("Test") }) { result ->
        assertEquals("Test", result.id)
        assertEquals(0, result.level)
    }

    /**
     * Verifies that endpoints returning a character use an explicit default because it does not use an id parameter.
     */
    @Test
    fun character() {
        // Arrange
        val defaultAssertion: (Character) -> Unit = { result ->
            assertEquals("Test", result.name)
            assertEquals(1, result.level)
            assertEquals(0, result.deathCount)
            assertContentEquals(emptyList(), result.backstory)
        }

        // Act / Assert
        testRecovery({ character.core("Test") }, defaultAssertion)
        testRecovery({ character.overview("Test") }, defaultAssertion)
    }

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

    /**
     * Verifies that a chunkedTabs call can be recovered.
     */
    @Test
    fun chunkedTabs() {
        // Arrange
        val id = -1

        // Act / Assert
        testRecovery({ character.buildTabs("", listOf(id)) }) { results ->
            assertEquals(1, results.size)
            assertEquals(id, results.single().id)
        }
    }

    /**
     * Verifies that a forceGetSingle call cannot be recovered.
     */
    @Test
    fun forceGetSingle() = failedRecovery { token.information("") }
}