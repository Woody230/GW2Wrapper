package com.bselzer.library.gw2.v2.client.jvm.unit

import com.bselzer.library.gw2.v2.model.common.profession.track.SkillTrack
import com.bselzer.library.gw2.v2.model.common.profession.track.TraitTrack
import io.ktor.client.engine.mock.*
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ProfessionTests : BaseUnitTests()
{
    override fun createEngineConfig(): MockEngineConfig.() -> Unit = {
        val response = getProfessionResource()
        exhaust(url = "https://api.guildwars2.com/v2/professions?ids=all", content = response)
    }

    /**
     * Verifies that the profession endpoint is being called and the response is deserialized correctly.
     */
    @Test
    fun profession()
    {
        // Act
        val professions = use { profession.professions() }

        // Assert
        assertEquals(1, professions.size)

        val profession = professions.single()
        assertEquals("Necromancer", profession.id)
        assertEquals("Necromancer", profession.name)

        val spec = profession.trainings.firstOrNull { training -> training.name == "Reaper" }
        assertNotNull(spec)

        val skillTrack = spec.tracks.firstOrNull { track -> track is SkillTrack && track.id == 30488 }
        assertNotNull(skillTrack)
        assertEquals(55, skillTrack.cost)

        val traitTrack = spec.tracks.firstOrNull { track -> track is TraitTrack && track.id == 1985 }
        assertNotNull(traitTrack)
        assertEquals(30, traitTrack.cost)
    }
}