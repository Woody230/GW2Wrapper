package com.bselzer.gw2.v2.client.instrumented

import com.bselzer.gw2.v2.model.enumeration.extension.profession.attunement
import com.bselzer.gw2.v2.model.enumeration.extension.profession.offhand
import com.bselzer.gw2.v2.model.enumeration.extension.profession.slot
import com.bselzer.gw2.v2.model.enumeration.extension.profession.source
import com.bselzer.gw2.v2.model.profession.Profession
import com.bselzer.gw2.v2.model.profession.ProfessionId
import com.bselzer.gw2.v2.model.profession.track.SkillTrack
import com.bselzer.gw2.v2.model.profession.track.TraitTrack
import org.junit.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class ProfessionTests : BaseInstrumentedTests() {
    /**
     * Verifies that the profession endpoint is being called and the response is deserialized correctly.
     */
    @Test
    fun elementalist() {
        // Act
        val profession = use { profession.profession(ProfessionId("Elementalist")) }

        // Assert
        assertProfession(profession)
        assertTrue(profession.skills.any { skill -> skill.attunement() != null && !skill.id.isDefault })
    }

    @Test
    fun thief() {
        // Act
        val profession = use { profession.profession(ProfessionId("Thief")) }

        // Assert
        assertProfession(profession)
        assertTrue(profession.skills.any { skill -> skill.source() != null && !skill.id.isDefault })
        assertTrue(profession.weapons.values.flatMap { weapon -> weapon.skills }.any { skill -> skill.offhand() != null && !skill.id.isDefault })
    }

    @Test
    fun necromancer() {
        // Act
        val profession = use { profession.profession(ProfessionId("Necromancer")) }

        // Assert
        assertProfession(profession)
    }

    private fun assertProfession(profession: Profession) {
        assertNotNull(profession)
        assertTrue(profession.specializationIds.isNotEmpty())

        val tracks = profession.trainings.flatMap { training -> training.tracks }
        assertTrue(tracks.any { track -> track is SkillTrack && !track.id.isDefault })
        assertTrue(tracks.any { track -> track is TraitTrack && !track.id.isDefault })
        assertTrue(profession.skills.isNotEmpty())
        assertTrue(profession.skills.any { skill -> skill.slot() != null })
        assertTrue(profession.weapons.isNotEmpty())
        assertTrue(profession.weapons.values.flatMap { weapon -> weapon.skills }.isNotEmpty())
    }
}