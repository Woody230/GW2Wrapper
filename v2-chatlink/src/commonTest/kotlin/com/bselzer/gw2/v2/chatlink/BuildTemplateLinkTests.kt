package com.bselzer.gw2.v2.chatlink

import com.bselzer.gw2.v2.chatlink.build.BuildTemplateLink
import com.bselzer.gw2.v2.chatlink.build.profession.*
import com.bselzer.gw2.v2.chatlink.build.skill.LinkSkill
import com.bselzer.gw2.v2.chatlink.build.specialization.LinkSpecialization
import com.bselzer.gw2.v2.chatlink.build.specialization.TraitChoice
import com.bselzer.gw2.v2.model.legend.LegendCode
import com.bselzer.gw2.v2.model.pet.PetId
import com.bselzer.gw2.v2.model.skill.SkillCode
import com.bselzer.gw2.v2.model.specialization.SpecializationId
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class BuildTemplateLinkTests : ChatLinkTests<BuildTemplateLink>() {
    private companion object {
        const val NECROMANCER_BLANK_LINK = "[&DQgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA=]"
        const val NECROMANCER_LINK: String = "[&DQg1KTIpIjXBEqIAgQD6AEABphK9AYAAAxOSAAAAAAAAAAAAAAAAAAAAAAA=]"
        val NECROMANCER_PROFESSION = ProfessionCode(8)
        val NECROMANCER_SPEC1 = SpecializationId(53)
        val NECROMANCER_SPEC2 = SpecializationId(50)
        val NECROMANCER_SPEC3 = SpecializationId(34)
        val NECROMANCER_SPEC1_TRAIT1 = TraitChoice(1)
        val NECROMANCER_SPEC1_TRAIT2 = TraitChoice(2)
        val NECROMANCER_SPEC1_TRAIT3 = TraitChoice(2)
        val NECROMANCER_SPEC2_TRAIT1 = TraitChoice(1)
        val NECROMANCER_SPEC2_TRAIT2 = TraitChoice(2)
        val NECROMANCER_SPEC2_TRAIT3 = TraitChoice(2)
        val NECROMANCER_SPEC3_TRAIT1 = TraitChoice(1)
        val NECROMANCER_SPEC3_TRAIT2 = TraitChoice(1)
        val NECROMANCER_SPEC3_TRAIT3 = TraitChoice(3)
        val NECROMANCER_LAND_HEAL = SkillCode(4801)
        val NECROMANCER_WATER_HEAL = SkillCode(162)
        val NECROMANCER_LAND_UTILITY1 = SkillCode(129)
        val NECROMANCER_WATER_UTILITY1 = SkillCode(250)
        val NECROMANCER_LAND_UTILITY2 = SkillCode(320)
        val NECROMANCER_WATER_UTILITY2 = SkillCode(4774)
        val NECROMANCER_LAND_UTILITY3 = SkillCode(445)
        val NECROMANCER_WATER_UTILITY3 = SkillCode(128)
        val NECROMANCER_LAND_ELITE = SkillCode(4867)
        val NECROMANCER_WATER_ELITE = SkillCode(146)

        // The skill palette ids may be the same if they align with the same slot, regardless of legend.
        // Consequently, the inactive heal/elite get ignored since they are always the same.
        const val REVENANT_LINK = "[&DQkOFQklPzrcEdwRKxIrEtQR1BEGEgYSyhHKEQQDBAIGEisS1BEGEisS1BE=]"
        val REVENANT_PROFESSION = ProfessionCode(9)
        val REVENANT_SPEC1 = SpecializationId(14)
        val REVENANT_SPEC2 = SpecializationId(9)
        val REVENANT_SPEC3 = SpecializationId(63)
        val REVENANT_SPEC1_TRAIT1 = TraitChoice(1)
        val REVENANT_SPEC1_TRAIT2 = TraitChoice(1)
        val REVENANT_SPEC1_TRAIT3 = TraitChoice(1)
        val REVENANT_SPEC2_TRAIT1 = TraitChoice(1)
        val REVENANT_SPEC2_TRAIT2 = TraitChoice(1)
        val REVENANT_SPEC2_TRAIT3 = TraitChoice(2)
        val REVENANT_SPEC3_TRAIT1 = TraitChoice(2)
        val REVENANT_SPEC3_TRAIT2 = TraitChoice(2)
        val REVENANT_SPEC3_TRAIT3 = TraitChoice(3)
        val REVENANT_LAND_HEAL = SkillCode(4572)
        val REVENANT_WATER_HEAL = SkillCode(4572)
        val REVENANT_LAND_UTILITY1 = SkillCode(4651)
        val REVENANT_WATER_UTILITY1 = SkillCode(4651)
        val REVENANT_LAND_UTILITY2 = SkillCode(4564)
        val REVENANT_WATER_UTILITY2 = SkillCode(4564)
        val REVENANT_LAND_UTILITY3 = SkillCode(4614)
        val REVENANT_WATER_UTILITY3 = SkillCode(4614)
        val REVENANT_LAND_ELITE = SkillCode(4554)
        val REVENANT_WATER_ELITE = SkillCode(4554)
        val REVENANT_ACTIVE_LAND_LEGEND = LegendCode(4)
        val REVENANT_ACTIVE_WATER_LEGEND = LegendCode(4)
        val REVENANT_INACTIVE_LAND_LEGEND = LegendCode(3)
        val REVENANT_INACTIVE_WATER_LEGEND = LegendCode(2)
        val REVENANT_INACTIVE_LAND_HEAL = SkillCode(4572)
        val REVENANT_INACTIVE_WATER_HEAL = SkillCode(4572)
        val REVENANT_INACTIVE_LAND_UTILITY1 = SkillCode(4614)
        val REVENANT_INACTIVE_WATER_UTILITY1 = SkillCode(4614)
        val REVENANT_INACTIVE_LAND_UTILITY2 = SkillCode(4651)
        val REVENANT_INACTIVE_WATER_UTILITY2 = SkillCode(4651)
        val REVENANT_INACTIVE_LAND_UTILITY3 = SkillCode(4564)
        val REVENANT_INACTIVE_WATER_UTILITY3 = SkillCode(4564)
        val REVENANT_INACTIVE_LAND_ELITE = SkillCode(4554)
        val REVENANT_INACTIVE_WATER_ELITE = SkillCode(4554)

        const val RANGER_LINK = "[&DQQhNh4vNy6hAHgAugC+AL4AGwD6FpoAwADtAD0iFRQAAAAAAAAAAAAAAAA=]"
        val RANGER_PROFESSION = ProfessionCode(4)
        val RANGER_SPEC1 = SpecializationId(33)
        val RANGER_SPEC2 = SpecializationId(30)
        val RANGER_SPEC3 = SpecializationId(55)
        val RANGER_SPEC1_TRAIT1 = TraitChoice(2)
        val RANGER_SPEC1_TRAIT2 = TraitChoice(1)
        val RANGER_SPEC1_TRAIT3 = TraitChoice(3)
        val RANGER_SPEC2_TRAIT1 = TraitChoice(3)
        val RANGER_SPEC2_TRAIT2 = TraitChoice(3)
        val RANGER_SPEC2_TRAIT3 = TraitChoice(2)
        val RANGER_SPEC3_TRAIT1 = TraitChoice(2)
        val RANGER_SPEC3_TRAIT2 = TraitChoice(3)
        val RANGER_SPEC3_TRAIT3 = TraitChoice(2)
        val RANGER_LAND_HEAL = SkillCode(161)
        val RANGER_WATER_HEAL = SkillCode(120)
        val RANGER_LAND_UTILITY1 = SkillCode(186)
        val RANGER_WATER_UTILITY1 = SkillCode(190)
        val RANGER_LAND_UTILITY2 = SkillCode(190)
        val RANGER_WATER_UTILITY2 = SkillCode(27)
        val RANGER_LAND_UTILITY3 = SkillCode(5882)
        val RANGER_WATER_UTILITY3 = SkillCode(154)
        val RANGER_LAND_ELITE = SkillCode(192)
        val RANGER_WATER_ELITE = SkillCode(237)
        val RANGER_LAND_PET1 = PetId(61)
        val RANGER_WATER_PET1 = PetId(21)
        val RANGER_LAND_PET2 = PetId(34)
        val RANGER_WATER_PET2 = PetId(20)
    }

    override val instance: BuildTemplateLink = BuildTemplateLink()

    @Test
    fun encodeBlankNecromancer() {
        // Arrange
        instance.profession = NECROMANCER_PROFESSION

        // Act
        val output = instance.encode()

        // Assert
        assertEquals(output, NECROMANCER_BLANK_LINK)
    }

    @Test
    fun decodeBlankNecromancer() {
        // Act
        val output = decode(NECROMANCER_BLANK_LINK)

        // Assert
        assertEquals(NECROMANCER_PROFESSION, output.profession)
        assertEquals(0, output.specialization1.specializationId.value)
        assertEquals(0, output.specialization2.specializationId.value)
        assertEquals(0, output.specialization3.specializationId.value)
        assertEquals(0, output.healSkill.terrestrialId.value)
        assertEquals(0, output.eliteSkill.aquaticId.value)
        assertTrue(output.professionData.getData().all { data -> data == 0.toByte() })
    }

    @Test
    fun encodeNecromancer() {
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
    fun decodeNecromancer() {
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

    @Test
    fun encodeRevenant() {
        // Arrange
        instance.profession = REVENANT_PROFESSION
        instance.specialization1 = LinkSpecialization(REVENANT_SPEC1, REVENANT_SPEC1_TRAIT1, REVENANT_SPEC1_TRAIT2, REVENANT_SPEC1_TRAIT3)
        instance.specialization2 = LinkSpecialization(REVENANT_SPEC2, REVENANT_SPEC2_TRAIT1, REVENANT_SPEC2_TRAIT2, REVENANT_SPEC2_TRAIT3)
        instance.specialization3 = LinkSpecialization(REVENANT_SPEC3, REVENANT_SPEC3_TRAIT1, REVENANT_SPEC3_TRAIT2, REVENANT_SPEC3_TRAIT3)
        instance.healSkill = LinkSkill(REVENANT_LAND_HEAL, REVENANT_WATER_HEAL)
        instance.utilitySkill1 = LinkSkill(REVENANT_LAND_UTILITY1, REVENANT_WATER_UTILITY1)
        instance.utilitySkill2 = LinkSkill(REVENANT_LAND_UTILITY2, REVENANT_WATER_UTILITY2)
        instance.utilitySkill3 = LinkSkill(REVENANT_LAND_UTILITY3, REVENANT_WATER_UTILITY3)
        instance.eliteSkill = LinkSkill(REVENANT_LAND_ELITE, REVENANT_WATER_ELITE)

        val activeLegend = LinkLegend(REVENANT_ACTIVE_LAND_LEGEND, REVENANT_ACTIVE_WATER_LEGEND)
        val inactiveLegend = LinkLegend(REVENANT_INACTIVE_LAND_LEGEND, REVENANT_INACTIVE_WATER_LEGEND)
        val utility1 = LinkSkill(REVENANT_INACTIVE_LAND_UTILITY1, REVENANT_INACTIVE_WATER_UTILITY1)
        val utility2 = LinkSkill(REVENANT_INACTIVE_LAND_UTILITY2, REVENANT_INACTIVE_WATER_UTILITY2)
        val utility3 = LinkSkill(REVENANT_INACTIVE_LAND_UTILITY3, REVENANT_INACTIVE_WATER_UTILITY3)
        instance.professionData = LinkRevenantData(activeLegend, inactiveLegend, utility1, utility2, utility3)

        // Act
        val output = instance.encode()

        // Assert
        assertEquals(output, REVENANT_LINK)
    }

    @Test
    fun decodeRevenant() {
        // Act
        val output = decode(REVENANT_LINK)

        // Assert
        assertEquals(REVENANT_PROFESSION, output.profession)

        assertEquals(REVENANT_SPEC1, output.specialization1.specializationId)
        assertEquals(REVENANT_SPEC1_TRAIT1, output.specialization1.trait1)
        assertEquals(REVENANT_SPEC1_TRAIT2, output.specialization1.trait2)
        assertEquals(REVENANT_SPEC1_TRAIT3, output.specialization1.trait3)

        assertEquals(REVENANT_SPEC2, output.specialization2.specializationId)
        assertEquals(REVENANT_SPEC2_TRAIT1, output.specialization2.trait1)
        assertEquals(REVENANT_SPEC2_TRAIT2, output.specialization2.trait2)
        assertEquals(REVENANT_SPEC2_TRAIT3, output.specialization2.trait3)

        assertEquals(REVENANT_SPEC3, output.specialization3.specializationId)
        assertEquals(REVENANT_SPEC3_TRAIT1, output.specialization3.trait1)
        assertEquals(REVENANT_SPEC3_TRAIT2, output.specialization3.trait2)
        assertEquals(REVENANT_SPEC3_TRAIT3, output.specialization3.trait3)

        assertEquals(REVENANT_LAND_HEAL, output.healSkill.terrestrialId)
        assertEquals(REVENANT_WATER_HEAL, output.healSkill.aquaticId)

        assertEquals(REVENANT_LAND_UTILITY1, output.utilitySkill1.terrestrialId)
        assertEquals(REVENANT_WATER_UTILITY1, output.utilitySkill1.aquaticId)

        assertEquals(REVENANT_LAND_UTILITY2, output.utilitySkill2.terrestrialId)
        assertEquals(REVENANT_WATER_UTILITY2, output.utilitySkill2.aquaticId)

        assertEquals(REVENANT_LAND_UTILITY3, output.utilitySkill3.terrestrialId)
        assertEquals(REVENANT_WATER_UTILITY3, output.utilitySkill3.aquaticId)

        assertEquals(REVENANT_LAND_ELITE, output.eliteSkill.terrestrialId)
        assertEquals(REVENANT_WATER_ELITE, output.eliteSkill.aquaticId)

        val data = output.professionData as LinkRevenantData
        assertNotNull(data)

        assertEquals(REVENANT_ACTIVE_LAND_LEGEND, data.activeLegend.terrestrialId)
        assertEquals(REVENANT_ACTIVE_WATER_LEGEND, data.activeLegend.aquaticId)
        assertEquals(REVENANT_INACTIVE_LAND_LEGEND, data.inactiveLegend.terrestrialId)
        assertEquals(REVENANT_INACTIVE_WATER_LEGEND, data.inactiveLegend.aquaticId)

        assertEquals(REVENANT_INACTIVE_LAND_UTILITY1, data.utilitySkill1.terrestrialId)
        assertEquals(REVENANT_INACTIVE_WATER_UTILITY1, data.utilitySkill1.aquaticId)

        assertEquals(REVENANT_INACTIVE_LAND_UTILITY2, data.utilitySkill2.terrestrialId)
        assertEquals(REVENANT_INACTIVE_WATER_UTILITY2, data.utilitySkill2.aquaticId)

        assertEquals(REVENANT_INACTIVE_LAND_UTILITY3, data.utilitySkill3.terrestrialId)
        assertEquals(REVENANT_INACTIVE_WATER_UTILITY3, data.utilitySkill3.aquaticId)
    }

    @Test
    fun encodeRanger() {
        // Arrange
        instance.profession = RANGER_PROFESSION
        instance.specialization1 = LinkSpecialization(RANGER_SPEC1, RANGER_SPEC1_TRAIT1, RANGER_SPEC1_TRAIT2, RANGER_SPEC1_TRAIT3)
        instance.specialization2 = LinkSpecialization(RANGER_SPEC2, RANGER_SPEC2_TRAIT1, RANGER_SPEC2_TRAIT2, RANGER_SPEC2_TRAIT3)
        instance.specialization3 = LinkSpecialization(RANGER_SPEC3, RANGER_SPEC3_TRAIT1, RANGER_SPEC3_TRAIT2, RANGER_SPEC3_TRAIT3)
        instance.healSkill = LinkSkill(RANGER_LAND_HEAL, RANGER_WATER_HEAL)
        instance.utilitySkill1 = LinkSkill(RANGER_LAND_UTILITY1, RANGER_WATER_UTILITY1)
        instance.utilitySkill2 = LinkSkill(RANGER_LAND_UTILITY2, RANGER_WATER_UTILITY2)
        instance.utilitySkill3 = LinkSkill(RANGER_LAND_UTILITY3, RANGER_WATER_UTILITY3)
        instance.eliteSkill = LinkSkill(RANGER_LAND_ELITE, RANGER_WATER_ELITE)

        val pet1 = LinkPet(RANGER_LAND_PET1, RANGER_WATER_PET1)
        val pet2 = LinkPet(RANGER_LAND_PET2, RANGER_WATER_PET2)
        instance.professionData = LinkRangerData(pet1, pet2)

        // Act
        val output = instance.encode()

        // Assert
        assertEquals(output, RANGER_LINK)
    }

    @Test
    fun decodeRanger() {
        // Act
        val output = decode(RANGER_LINK)

        // Assert
        assertEquals(RANGER_PROFESSION, output.profession)

        assertEquals(RANGER_SPEC1, output.specialization1.specializationId)
        assertEquals(RANGER_SPEC1_TRAIT1, output.specialization1.trait1)
        assertEquals(RANGER_SPEC1_TRAIT2, output.specialization1.trait2)
        assertEquals(RANGER_SPEC1_TRAIT3, output.specialization1.trait3)

        assertEquals(RANGER_SPEC2, output.specialization2.specializationId)
        assertEquals(RANGER_SPEC2_TRAIT1, output.specialization2.trait1)
        assertEquals(RANGER_SPEC2_TRAIT2, output.specialization2.trait2)
        assertEquals(RANGER_SPEC2_TRAIT3, output.specialization2.trait3)

        assertEquals(RANGER_SPEC3, output.specialization3.specializationId)
        assertEquals(RANGER_SPEC3_TRAIT1, output.specialization3.trait1)
        assertEquals(RANGER_SPEC3_TRAIT2, output.specialization3.trait2)
        assertEquals(RANGER_SPEC3_TRAIT3, output.specialization3.trait3)

        assertEquals(RANGER_LAND_HEAL, output.healSkill.terrestrialId)
        assertEquals(RANGER_WATER_HEAL, output.healSkill.aquaticId)

        assertEquals(RANGER_LAND_UTILITY1, output.utilitySkill1.terrestrialId)
        assertEquals(RANGER_WATER_UTILITY1, output.utilitySkill1.aquaticId)

        assertEquals(RANGER_LAND_UTILITY2, output.utilitySkill2.terrestrialId)
        assertEquals(RANGER_WATER_UTILITY2, output.utilitySkill2.aquaticId)

        assertEquals(RANGER_LAND_UTILITY3, output.utilitySkill3.terrestrialId)
        assertEquals(RANGER_WATER_UTILITY3, output.utilitySkill3.aquaticId)

        assertEquals(RANGER_LAND_ELITE, output.eliteSkill.terrestrialId)
        assertEquals(RANGER_WATER_ELITE, output.eliteSkill.aquaticId)

        val data = output.professionData as LinkRangerData
        assertNotNull(data)

        assertEquals(RANGER_LAND_PET1, data.activePet.terrestrialId)
        assertEquals(RANGER_WATER_PET1, data.activePet.aquaticId)
        assertEquals(RANGER_LAND_PET2, data.inactivePet.terrestrialId)
        assertEquals(RANGER_WATER_PET2, data.inactivePet.aquaticId)
    }
}