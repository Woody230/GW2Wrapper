package com.bselzer.gw2.v2.model.enumeration

import com.bselzer.gw2.v2.model.enumeration.extension.language
import com.bselzer.gw2.v2.model.enumeration.extension.region
import com.bselzer.gw2.v2.model.world.WorldId
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class WorldTests {
    @Test
    fun region() {
        // Arrange
        val naEnglish = WorldId(1016)
        val euEnglish = WorldId(2005)
        val euFrench = WorldId(2104)
        val euGerman = WorldId(2203)
        val euSpanish = WorldId(2301)
        val invalid = WorldId(9999)

        // Act / Assert
        assertEquals(WorldRegion.NORTH_AMERICA, naEnglish.region())
        assertEquals(WorldRegion.EUROPE, euEnglish.region())
        assertEquals(WorldRegion.EUROPE, euFrench.region())
        assertEquals(WorldRegion.EUROPE, euGerman.region())
        assertEquals(WorldRegion.EUROPE, euSpanish.region())
        assertNull(invalid.region())
    }

    @Test
    fun language() {
        // Arrange
        val naEnglish = WorldId(1016)
        val euEnglish = WorldId(2005)
        val euFrench = WorldId(2104)
        val euGerman = WorldId(2203)
        val euSpanish = WorldId(2301)
        val invalid = WorldId(9999)

        // Act / Assert
        assertEquals(WorldLanguage.ENGLISH, naEnglish.language())
        assertEquals(WorldLanguage.ENGLISH, euEnglish.language())
        assertEquals(WorldLanguage.FRENCH, euFrench.language())
        assertEquals(WorldLanguage.GERMAN, euGerman.language())
        assertEquals(WorldLanguage.SPANISH, euSpanish.language())
        assertNull(invalid.language())
    }
}