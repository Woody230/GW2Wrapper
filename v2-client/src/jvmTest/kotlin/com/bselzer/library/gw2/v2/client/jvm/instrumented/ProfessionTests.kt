package com.bselzer.library.gw2.v2.client.jvm.instrumented

import com.bselzer.library.gw2.v2.client.common.client.Gw2Client
import com.bselzer.library.gw2.v2.client.common.client.Gw2Client.Companion.DEFAULT_JSON
import com.bselzer.library.gw2.v2.model.common.profession.track.SkillTrack
import com.bselzer.library.gw2.v2.model.common.profession.track.TraitTrack
import com.bselzer.library.gw2.v2.model.extension.common.serialization.module.Profession
import io.ktor.client.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
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

        // TODO default should include serializer modules
        val gw2Client = Gw2Client(httpClient, Json(DEFAULT_JSON) {
            serializersModule = Profession.TRACK
        })

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