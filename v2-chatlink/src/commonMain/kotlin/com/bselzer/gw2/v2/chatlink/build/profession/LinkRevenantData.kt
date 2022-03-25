package com.bselzer.gw2.v2.chatlink.build.profession

import com.bselzer.gw2.v2.chatlink.build.skill.LinkSkill
import com.bselzer.gw2.v2.model.legend.LegendCode
import com.bselzer.gw2.v2.model.skill.SkillCode
import com.bselzer.ktx.function.collection.removeFirst
import com.bselzer.ktx.function.collection.toByteArray
import com.bselzer.ktx.function.collection.toShort
import kotlinx.serialization.Serializable

@Serializable
data class LinkRevenantData(
    /**
     * The active legend ids.
     */
    var activeLegend: LinkLegend = LinkLegend(),

    /**
     * The inactive legend ids.
     */
    var inactiveLegend: LinkLegend = LinkLegend(),

    /**
     * The inactive utility skill 1 ids.
     */
    var utilitySkill1: LinkSkill = LinkSkill(),

    /**
     * The inactive utility skill 2 ids.
     */
    var utilitySkill2: LinkSkill = LinkSkill(),

    /**
     * The inactive utility skill 3 ids.
     */
    var utilitySkill3: LinkSkill = LinkSkill(),
) : LinkProfessionData() {
    override fun getData(): ByteArray {
        val legends = byteArrayOf(activeLegend.terrestrialId.value, inactiveLegend.terrestrialId.value, activeLegend.aquaticId.value, inactiveLegend.aquaticId.value)
        val landSkills = utilitySkill1.terrestrialId.value.toByteArray() + utilitySkill2.terrestrialId.value.toByteArray() + utilitySkill3.terrestrialId.value.toByteArray()
        val waterSkills = utilitySkill1.aquaticId.value.toByteArray() + utilitySkill2.aquaticId.value.toByteArray() + utilitySkill3.aquaticId.value.toByteArray()
        return legends + landSkills + waterSkills
    }

    override fun decode(bytes: ArrayDeque<Byte>) {
        // Ensure bytes size.
        super.decode(bytes)

        activeLegend.terrestrialId = bytes.takeLegend()
        inactiveLegend.terrestrialId = bytes.takeLegend()
        activeLegend.aquaticId = bytes.takeLegend()
        inactiveLegend.aquaticId = bytes.takeLegend()
        utilitySkill1.terrestrialId = bytes.takeSkill()
        utilitySkill2.terrestrialId = bytes.takeSkill()
        utilitySkill3.terrestrialId = bytes.takeSkill()
        utilitySkill1.aquaticId = bytes.takeSkill()
        utilitySkill2.aquaticId = bytes.takeSkill()
        utilitySkill3.aquaticId = bytes.takeSkill()
    }

    /**
     * Takes the first bytes as a [LegendCode].
     */
    private fun ArrayDeque<Byte>.takeLegend() = LegendCode(removeFirst())

    /**
     * Takes the first bytes as a [SkillCode].
     */
    private fun ArrayDeque<Byte>.takeSkill() = SkillCode(removeFirst(take = 2).toShort())
}