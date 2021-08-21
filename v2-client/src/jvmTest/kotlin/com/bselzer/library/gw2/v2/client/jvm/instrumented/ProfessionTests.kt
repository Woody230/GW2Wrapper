package com.bselzer.library.gw2.v2.client.jvm.instrumented

import com.bselzer.library.gw2.v2.client.common.client.Gw2Client
import com.bselzer.library.gw2.v2.model.common.profession.track.SkillTrack
import com.bselzer.library.gw2.v2.model.common.profession.track.TraitTrack
import io.ktor.client.*
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class ProfessionTests
{
    /**
     * Verifies that the profession endpoint is being called and the response is deserialized correctly.
     */
    @Test
    fun profession()
    {
        // Arrange
        val httpClient = HttpClient()
        val gw2Client = Gw2Client(httpClient)

        // Act
        val profession = runBlocking {
            gw2Client.use {
                it.profession.profession("Necromancer")
            }
        }

        // Assert
        assertNotNull(profession)
        assertTrue(profession.specializationIds.isNotEmpty())

        val tracks = profession.trainings.flatMap { training -> training.tracks }
        assertTrue(tracks.any { track -> track is SkillTrack && track.id > 0 })
        assertTrue(tracks.any { track -> track is TraitTrack && track.id > 0 })
    }
}