package com.bselzer.library.gw2.v2.model.extension.common

import com.bselzer.library.gw2.v2.model.common.world.World
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.world.WorldLanguage
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.world.WorldRegion
import com.bselzer.library.gw2.v2.model.extension.common.model.world.language
import com.bselzer.library.gw2.v2.model.extension.common.model.world.region
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class WorldTests
{
    @Test
    fun region()
    {
        // Arrange
        val naEnglish = World(id = 1016)
        val euEnglish = World(id = 2005)
        val euFrench = World(id = 2104)
        val euGerman = World(id = 2203)
        val euSpanish = World(id = 2301)
        val invalid = World(id = 9999)

        // Act / Assert
        assertEquals(WorldRegion.NORTH_AMERICA, naEnglish.region())
        assertEquals(WorldRegion.EUROPE, euEnglish.region())
        assertEquals(WorldRegion.EUROPE, euFrench.region())
        assertEquals(WorldRegion.EUROPE, euGerman.region())
        assertEquals(WorldRegion.EUROPE, euSpanish.region())
        assertNull(invalid.region())
    }

    @Test
    fun language()
    {
        // Arrange
        val naEnglish = World(id = 1016)
        val euEnglish = World(id = 2005)
        val euFrench = World(id = 2104)
        val euGerman = World(id = 2203)
        val euSpanish = World(id = 2301)
        val invalid = World(id = 9999)

        // Act / Assert
        assertEquals(WorldLanguage.ENGLISH, naEnglish.language())
        assertEquals(WorldLanguage.ENGLISH, euEnglish.language())
        assertEquals(WorldLanguage.FRENCH, euFrench.language())
        assertEquals(WorldLanguage.GERMAN, euGerman.language())
        assertEquals(WorldLanguage.SPANISH, euSpanish.language())
        assertNull(invalid.language())
    }
}