package com.bselzer.library.gw2.v2.model.extension.common.chatlink.build.profession

import com.bselzer.library.kotlin.extension.function.common.collection.fill
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
        val filler = listOf<Byte>().fill(8) { 0 }
        return pets + filler
    }

    override fun decode(bytes: ArrayDeque<Byte>)
    {
        // Ensure bytes size.
        super.decode(bytes)

        activePet.terrestrialId = bytes.removeFirst()
        inactivePet.terrestrialId = bytes.removeFirst()
        activePet.aquaticId = bytes.removeFirst()
        inactivePet.aquaticId = bytes.removeFirst()
    }
}