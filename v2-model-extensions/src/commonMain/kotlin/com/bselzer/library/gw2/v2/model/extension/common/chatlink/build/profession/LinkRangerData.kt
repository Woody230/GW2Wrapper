package com.bselzer.library.gw2.v2.model.extension.common.chatlink.build.profession

import kotlinx.serialization.Serializable

@Serializable
data class LinkRangerData(
    /**
     * The active pet ids.
     */
    var activePet: LinkPet = LinkPet(),

    /**
     * The inactive pet ids.
     */
    var inactivePet: LinkPet = LinkPet()
) : LinkProfessionData()
{
    companion object
    {
        const val CODE: Byte = 4
    }

    override fun getData(): ByteArray
    {
        val pets = byteArrayOf(activePet.terrestrialId, inactivePet.terrestrialId, activePet.aquaticId, inactivePet.aquaticId)
        val filler = (1..8).map { 0.toByte() }
        return pets + filler
    }

    override fun decode(bytes: ByteArray)
    {
        // Ensure bytes size.
        super.decode(bytes)

        activePet.terrestrialId = bytes[0]
        inactivePet.terrestrialId = bytes[1]
        activePet.aquaticId = bytes[2]
        inactivePet.aquaticId = bytes[3]
    }
}