package com.bselzer.library.gw2.v2.model.extension.common

import com.bselzer.library.gw2.v2.model.extension.common.chatlink.build.BuildTemplateLink
import com.bselzer.library.gw2.v2.model.extension.common.chatlink.build.LinkSkill
import com.bselzer.library.gw2.v2.model.extension.common.chatlink.build.LinkSpecialization
import com.bselzer.library.gw2.v2.model.extension.common.chatlink.build.profession.LinkProfessionData
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BuildTemplateLinkTests : ChatLinkTests<BuildTemplateLink>()
{
    private companion object
    {
        const val NECROMANCER_BLANK_LINK = "[&DQgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA=]"
        const val NECROMANCER_LINK: String = "[&DQg1KTIpIjXBEqIAgQD6AEABphK9AYAAAxOSAAAAAAAAAAAAAAAAAAAAAAA=]"
        const val NECROMANCER_PROFESSION: Byte = 8
        const val NECROMANCER_SPEC1: Byte = 53
        const val NECROMANCER_SPEC2: Byte = 50
        const val NECROMANCER_SPEC3: Byte = 34
        const val NECROMANCER_SPEC1_TRAIT1: Byte = 1
        const val NECROMANCER_SPEC1_TRAIT2: Byte = 2
        const val NECROMANCER_SPEC1_TRAIT3: Byte = 2
        const val NECROMANCER_SPEC2_TRAIT1: Byte = 1
        const val NECROMANCER_SPEC2_TRAIT2: Byte = 2
        const val NECROMANCER_SPEC2_TRAIT3: Byte = 2
        const val NECROMANCER_SPEC3_TRAIT1: Byte = 1
        const val NECROMANCER_SPEC3_TRAIT2: Byte = 1
        const val NECROMANCER_SPEC3_TRAIT3: Byte = 3
        const val NECROMANCER_LAND_HEAL: Short = 4801.toShort()
        const val NECROMANCER_WATER_HEAL: Short = 162.toShort()
        const val NECROMANCER_LAND_UTILITY1: Short = 129.toShort()
        const val NECROMANCER_WATER_UTILITY1: Short = 250.toShort()
        const val NECROMANCER_LAND_UTILITY2: Short = 320.toShort()
        const val NECROMANCER_WATER_UTILITY2: Short = 4774.toShort()
        const val NECROMANCER_LAND_UTILITY3: Short = 445.toShort()
        const val NECROMANCER_WATER_UTILITY3: Short = 128.toShort()
        const val NECROMANCER_LAND_ELITE: Short = 4867.toShort()
        const val NECROMANCER_WATER_ELITE: Short = 146.toShort()
    }

    override val instance: BuildTemplateLink = BuildTemplateLink()

    @Test
    fun encodeBlankNecromancer()
    {
        // Arrange
        instance.profession = NECROMANCER_PROFESSION

        // Act
        val output = instance.encode()

        // Assert
        assertEquals(output, NECROMANCER_BLANK_LINK)
    }

    @Test
    fun decodeBlankNecromancer()
    {
        // Act
        val output = decode(NECROMANCER_BLANK_LINK)

        // Assert
        assertEquals(NECROMANCER_PROFESSION, output.profession)
        assertEquals(0, output.specialization1.specializationId)
        assertEquals(0, output.specialization2.specializationId)
        assertEquals(0, output.specialization3.specializationId)
        assertEquals(0, output.healSkill.terrestrialId)
        assertEquals(0, output.eliteSkill.aquaticId)
        assertTrue(output.professionData.getData().all { data -> data == 0.toByte() })
    }

    @Test
    fun encodeNecromancer()
    {
        // Arrange
        instance.profession = NECROMANCER_PROFESSION
        instance.specialization1 = LinkSpecialization(NECROMANCER_SPEC1, NECROMANCER_SPEC1_TRAIT1, NECROMANCER_SPEC1_TRAIT2, NECROMANCER_SPEC1_TRAIT3)
        instance.specialization2 = LinkSpecialization(NECROMANCER_SPEC2, NECROMANCER_SPEC2_TRAIT1, NECROMANCER_SPEC2_TRAIT2, NECROMANCER_SPEC2_TRAIT3)
        instance.specialization3 = LinkSpecialization(NECROMANCER_SPEC3, NECROMANCER_SPEC3_TRAIT1, NECROMANCER_SPEC3_TRAIT2, NECROMANCER_SPEC3_TRAIT3)
        instance.healSkill = LinkSkill(NECROMANCER_LAND_HEAL, NECROMANCER_WATER_HEAL)
        instance.utilitySkill1 = LinkSkill(NECROMANCER_LAND_UTILITY1, NECROMANCER_WATER_UTILITY1)
        instance.utilitySkill2 = LinkSkill(NECROMANCER_LAND_UTILITY2, NECROMANCER_WATER_UTILITY2)
        instance.utilitySkill3 = LinkSkill(NECROMANCER_LAND_UTILITY3, NECROMANCER_WATER_UTILITY3)
        instance.eliteSkill = LinkSkill(NECROMANCER_LAND_ELITE, NECROMANCER_WATER_ELITE)
        instance.professionData = LinkProfessionData()

        // Act
        val output = instance.encode()

        // Assert
        assertEquals(output, NECROMANCER_LINK)
    }

    @Test
    fun decodeNecromancer()
    {
        // Act
        val output = decode(NECROMANCER_LINK)

        // Assert
        assertEquals(NECROMANCER_PROFESSION, output.profession)

        assertEquals(NECROMANCER_SPEC1, output.specialization1.specializationId)
        assertEquals(NECROMANCER_SPEC1_TRAIT1, output.specialization1.trait1)
        assertEquals(NECROMANCER_SPEC1_TRAIT2, output.specialization1.trait2)
        assertEquals(NECROMANCER_SPEC1_TRAIT3, output.specialization1.trait3)

        assertEquals(NECROMANCER_SPEC2, output.specialization2.specializationId)
        assertEquals(NECROMANCER_SPEC2_TRAIT1, output.specialization2.trait1)
        assertEquals(NECROMANCER_SPEC2_TRAIT2, output.specialization2.trait2)
        assertEquals(NECROMANCER_SPEC2_TRAIT3, output.specialization2.trait3)

        assertEquals(NECROMANCER_SPEC3, output.specialization3.specializationId)
        assertEquals(NECROMANCER_SPEC3_TRAIT1, output.specialization3.trait1)
        assertEquals(NECROMANCER_SPEC3_TRAIT2, output.specialization3.trait2)
        assertEquals(NECROMANCER_SPEC3_TRAIT3, output.specialization3.trait3)

        assertEquals(NECROMANCER_LAND_HEAL, output.healSkill.terrestrialId)
        assertEquals(NECROMANCER_WATER_HEAL, output.healSkill.aquaticId)

        assertEquals(NECROMANCER_LAND_UTILITY1, output.utilitySkill1.terrestrialId)
        assertEquals(NECROMANCER_WATER_UTILITY1, output.utilitySkill1.aquaticId)

        assertEquals(NECROMANCER_LAND_UTILITY2, output.utilitySkill2.terrestrialId)
        assertEquals(NECROMANCER_WATER_UTILITY2, output.utilitySkill2.aquaticId)

        assertEquals(NECROMANCER_LAND_UTILITY3, output.utilitySkill3.terrestrialId)
        assertEquals(NECROMANCER_WATER_UTILITY3, output.utilitySkill3.aquaticId)

        assertEquals(NECROMANCER_LAND_ELITE, output.eliteSkill.terrestrialId)
        assertEquals(NECROMANCER_WATER_ELITE, output.eliteSkill.aquaticId)

        assertTrue(output.professionData.getData().all { data -> data == 0.toByte() })
    }
}