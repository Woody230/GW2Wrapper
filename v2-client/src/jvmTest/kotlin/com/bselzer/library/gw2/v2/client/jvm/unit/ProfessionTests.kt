package com.bselzer.library.gw2.v2.client.jvm.unit

import asHeader
import com.bselzer.library.gw2.v2.client.common.client.Gw2Client
import com.bselzer.library.gw2.v2.client.common.client.Gw2Client.Companion.DEFAULT_JSON
import com.bselzer.library.gw2.v2.model.common.profession.track.SkillTrack
import com.bselzer.library.gw2.v2.model.common.profession.track.TraitTrack
import com.bselzer.library.gw2.v2.model.extension.common.serialization.module.Profession
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.plus
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ProfessionTests
{
    // TODO consolidate common test stuff
    /**
     * Verifies that the profession endpoint is being called and the response is deserialized correctly.
     */
    @Test
    fun profession()
    {
        // Arrange
        val resource = this::class.java.getResource("/Profession.json")!!.readText()
        val httpClient = HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.toString())
                    {
                        "https://api.guildwars2.com/v2/professions?ids=all" -> respond(
                            resource,
                            headers = ContentType.Application.Json.asHeader()
                        )
                        else -> error("Cannot handle ${request.url.fullPath}")
                    }
                }
            }
        }

        // TODO default should include serializer modules
        val gw2Client = Gw2Client(httpClient, Json(DEFAULT_JSON) {
            serializersModule = Profession.TRACK + Profession.SKILL
        })

        // Act
        val professions = runBlocking {
            gw2Client.use {
                it.profession.professions()
            }
        }

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