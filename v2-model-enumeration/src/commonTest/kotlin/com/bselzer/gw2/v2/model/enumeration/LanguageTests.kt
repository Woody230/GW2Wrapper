package com.bselzer.gw2.v2.model.enumeration

import com.bselzer.ktx.serialization.context.JsonContext.Default.decodeOrNull
import kotlin.test.Test
import kotlin.test.assertEquals

class LanguageTests {
    @Test
    fun decode() {
        // Arrange
        val value = "es"

        // Act
        val enum = value.decodeOrNull<Language>()

        // Assert
        assertEquals(enum, Language.SPANISH)
    }
}