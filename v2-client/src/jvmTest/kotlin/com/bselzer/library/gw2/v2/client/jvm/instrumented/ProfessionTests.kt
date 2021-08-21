package com.bselzer.library.gw2.v2.client.jvm.instrumented

import com.bselzer.library.gw2.v2.model.common.profession.Profession
import com.bselzer.library.gw2.v2.model.common.profession.skill.ElementalistSkill
import com.bselzer.library.gw2.v2.model.common.profession.track.SkillTrack
import com.bselzer.library.gw2.v2.model.common.profession.track.TraitTrack
import org.junit.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class ProfessionTests : BaseInstrumentedTests()
{
    /**
     * Verifies that the profession endpoint is being called and the response is deserialized correctly.
     */
    @Test
    fun elementalist()
    {
        // Act
        val profession = use { profession.profession("Elementalist") }

        // Assert
        assertProfession(profession)
        assertTrue(profession.skills.any { skill -> skill is ElementalistSkill && skill.id > 0 })
    }

    @Test
    fun necromancer()
    {
        // Act
        val profession = use { profession.profession("Necromancer") }

        // Assert
        assertProfession(profession)
    }

    private fun assertProfession(profession: Profession)
    {
        assertNotNull(profession)
        assertTrue(profession.specializationIds.isNotEmpty())

        val tracks = profession.trainings.flatMap { training -> training.tracks }
        assertTrue(tracks.any { track -> track is SkillTrack && track.id > 0 })
        assertTrue(tracks.any { track -> track is TraitTrack && track.id > 0 })
        assertTrue(profession.skills.isNotEmpty())
    }
}