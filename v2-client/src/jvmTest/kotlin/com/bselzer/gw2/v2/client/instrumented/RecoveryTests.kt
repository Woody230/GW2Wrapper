package com.bselzer.gw2.v2.client.instrumented

import com.bselzer.gw2.v2.model.achievement.AchievementId
import com.bselzer.gw2.v2.model.guild.upgrade.DefaultUpgrade
import com.bselzer.gw2.v2.model.guild.upgrade.GuildUpgrade
import com.bselzer.gw2.v2.model.guild.upgrade.GuildUpgradeId
import com.bselzer.gw2.v2.model.serialization.Modules
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class RecoveryTests : BaseInstrumentedTests() {
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
     * Verifies that a polymorphic object can be recovered.
     */
    @Test
    fun polymorphism() {
        // Arrange
        val id = GuildUpgradeId(-999)

        // Act / Assert
        testRecovery({ guild.upgrade(id) }) { result ->
            // Result should be defaulted, except for the id.
            assertEquals(id, result.id)
            assertEquals("", result.iconLink.value)
            assertEquals(0, result.requiredLevel.value)
            assertContentEquals(emptyList(), result.prerequisites)

            // The identifier parameter should not interfere with retaining the actual id parameter when encoding/decoding.
            val json = Json { serializersModule = Modules.GUILD_UPGRADE }
            val encoded = json.encodeToString(result)
            val decoded = json.decodeFromString<GuildUpgrade>(encoded)
            assertTrue { decoded is DefaultUpgrade }
            assertEquals(id, decoded.id)
            assertEquals("", decoded.iconLink.value)
            assertEquals(0, decoded.requiredLevel.value)
            assertContentEquals(emptyList(), decoded.prerequisites)
        }
    }
}