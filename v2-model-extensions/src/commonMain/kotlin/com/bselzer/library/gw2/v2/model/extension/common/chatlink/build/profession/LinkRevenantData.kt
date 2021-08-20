package com.bselzer.library.gw2.v2.model.extension.common.chatlink.build.profession

import com.bselzer.library.gw2.v2.model.extension.common.chatlink.build.LinkSkill
import com.bselzer.library.kotlin.extension.function.common.collection.toByteArray
import com.bselzer.library.kotlin.extension.function.common.collection.toShort
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
) : LinkProfessionData()
{
    companion object
    {
        const val CODE: Byte = 9
    }

    override fun getData(): ByteArray
    {
        val legends = byteArrayOf(activeLegend.terrestrialId, inactiveLegend.terrestrialId, activeLegend.aquaticId, inactiveLegend.aquaticId)
        val landSkills = utilitySkill1.terrestrialId.toByteArray() + utilitySkill2.terrestrialId.toByteArray() + utilitySkill3.terrestrialId.toByteArray()
        val waterSkills = utilitySkill1.aquaticId.toByteArray() + utilitySkill2.aquaticId.toByteArray() + utilitySkill3.aquaticId.toByteArray()
        return legends + landSkills + waterSkills
    }

    override fun decode(bytes: ByteArray)
    {
        // Ensure bytes size.
        super.decode(bytes)

        // TODO arraydeque
        activeLegend.terrestrialId = bytes[0]
        inactiveLegend.terrestrialId = bytes[1]
        activeLegend.aquaticId = bytes[2]
        inactiveLegend.aquaticId = bytes[3]
        utilitySkill1.terrestrialId = bytes.copyOfRange(4, 6).toShort()
        utilitySkill2.terrestrialId = bytes.copyOfRange(6, 8).toShort()
        utilitySkill3.terrestrialId = bytes.copyOfRange(8, 10).toShort()
        utilitySkill1.aquaticId = bytes.copyOfRange(10, 12).toShort()
        utilitySkill2.aquaticId = bytes.copyOfRange(12, 14).toShort()
        utilitySkill3.aquaticId = bytes.copyOfRange(14, 16).toShort()
    }
}