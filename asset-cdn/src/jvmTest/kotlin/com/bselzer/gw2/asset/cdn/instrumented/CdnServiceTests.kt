package com.bselzer.gw2.asset.cdn.instrumented

import com.bselzer.gw2.asset.cdn.BaseTests
import org.junit.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class CdnServiceTests : BaseTests() {
    /**
     * Verifies that the build can be retrieved from the service.
     */
    @Test
    fun latest() {
        // Act
        val content = use { latest() }

        // Assert
        assertNotNull(content)
        assertTrue { content.id.value > 0 }
        assertTrue { content.executableFileId > 0 }
        assertTrue { content.executableFileSize > 0 }
        assertTrue { content.manifestFileId > 0 }
        assertTrue { content.manifestFileSize > 0 }
    }
}