package com.bselzer.library.gw2.v2.chatlink.build.profession

import com.bselzer.library.gw2.v2.chatlink.build.LinkSkill
import com.bselzer.library.kotlin.extension.function.common.collection.removeFirst
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

    override fun decode(bytes: ArrayDeque<Byte>)
    {
        // Ensure bytes size.
        super.decode(bytes)

        activeLegend.terrestrialId = bytes.removeFirst()
        inactiveLegend.terrestrialId = bytes.removeFirst()
        activeLegend.aquaticId = bytes.removeFirst()
        inactiveLegend.aquaticId = bytes.removeFirst()
        utilitySkill1.terrestrialId = bytes.removeFirst(take = 2).toShort()
        utilitySkill2.terrestrialId = bytes.removeFirst(take = 2).toShort()
        utilitySkill3.terrestrialId = bytes.removeFirst(take = 2).toShort()
        utilitySkill1.aquaticId = bytes.removeFirst(take = 2).toShort()
        utilitySkill2.aquaticId = bytes.removeFirst(take = 2).toShort()
        utilitySkill3.aquaticId = bytes.removeFirst(take = 2).toShort()
    }
}