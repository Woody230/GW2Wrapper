package com.bselzer.gw2.v2.client.unit

import com.bselzer.gw2.v2.model.achievement.AchievementId
import com.bselzer.gw2.v2.model.build.BuildId
import com.bselzer.gw2.v2.model.character.Character
import com.bselzer.gw2.v2.model.character.CharacterName
import com.bselzer.gw2.v2.model.guild.GuildId
import com.bselzer.gw2.v2.model.template.build.BuildTemplateTabId
import io.ktor.client.engine.mock.*
import kotlinx.datetime.Instant
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
    fun allTabs() = testRecovery({ character.buildTabs(CharacterName("")) }) { results ->
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
    fun getIdentifiableSingle() = testRecovery({ guild.guild(GuildId("Test")) }) { result ->
        assertEquals(GuildId("Test"), result.id)
        assertEquals(0, result.level.value)
    }

    /**
     * Verifies that endpoints returning a character use an explicit default because it does not use an id parameter.
     */
    @Test
    fun character() {
        // Arrange
        val defaultAssertion: (Character) -> Unit = { result ->
            assertEquals(CharacterName("Test"), result.name)
            assertEquals(1, result.level.value)
            assertEquals(0, result.deathCount)
            assertContentEquals(emptyList(), result.backstory)
        }

        // Act / Assert
        testRecovery({ character.core(CharacterName("Test")) }, defaultAssertion)
        testRecovery({ character.overview(CharacterName("Test")) }, defaultAssertion)
    }

    /**
     * Verifies that the build endpoint can be recovered.
     */
    @Test
    fun build() = testRecovery({ build.buildId() }) { result ->
        assertEquals(BuildId(0), result)
    }

    /**
     * Verifies that a singleById call can be recovered.
     */
    @Test
    fun getSingleById() {
        // Arrange
        val id = AchievementId(-1)

        // Act / Assert
        testRecovery({ achievement.achievement(id) }) { result ->
            // Result should be defaulted, except for the id.
            assertEquals(id, result.id)
            assertEquals("", result.iconLink.value)
            assertEquals(0, result.pointCap.value)
            assertContentEquals(emptyList(), result.tiers)
        }
    }

    /**
     * Verifies that a chunkedIds call can be recovered.
     */
    @Test
    fun chunkedIds() {
        // Arrange
        val id = AchievementId(-1)

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
        val id = BuildTemplateTabId(-1)

        // Act / Assert
        testRecovery({ character.buildTabs(CharacterName(""), listOf(id)) }) { results ->
            assertEquals(1, results.size)
            assertEquals(id, results.single().id)
        }
    }

    /**
     * Verifies that a forceGetSingle call cannot be recovered.
     */
    @Test
    fun forceGetSingle() = failedRecovery { token.createSubToken(Instant.DISTANT_FUTURE, emptyList(), emptyList()) }
}