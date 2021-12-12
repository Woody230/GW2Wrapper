package com.bselzer.gw2.v2.emblem

import com.bselzer.gw2.v2.emblem.request.EmblemRequestOptions
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class EmblemServiceTests : BaseTests() {
    private val guildId = "c19c41d3-752d-e911-81a8-cde2ac1eed30"

    /**
     * Verifies that content can be retrieved from the emblem service.
     */
    @Test
    fun getsContent_WithoutOptions() {
        // Arrange
        val request = get { requestEmblem(guildId = guildId) }

        // Act
        val content = use { emblem(request) }

        // Assert
        assertNotNull(content)
        assertTrue(content.isNotEmpty())
    }

    /**
     * Verifies that content can be retrieved from the emblem service with options.
     */
    @Test
    fun getsContent_WithOptions() {
        // Arrange
        val request = get { requestEmblem(guildId = guildId, size = 64, EmblemRequestOptions.MAXIMIZE_BACKGROUND_ALPHA, EmblemRequestOptions.MAXIMIZE_FOREGROUND_ALPHA) }

        // Act
        val content = use { emblem(request) }

        // Assert
        assertNotNull(content)
        assertTrue(content.isNotEmpty())
    }

    /**
     * Verifies that content can be retrieved from the emblem service using the constructed url.
     */
    @Test
    fun emblemUrl_WithOptions() {
        // Arrange
        val request = get { requestEmblem(guildId = guildId) }
        val url = get { emblemUrl(request) }

        // Act
        val content = runBlocking { createHttpClient().get<ByteArray>(url) }

        // Assert
        assertNotNull(content)
        assertTrue(content.isNotEmpty())
    }
}