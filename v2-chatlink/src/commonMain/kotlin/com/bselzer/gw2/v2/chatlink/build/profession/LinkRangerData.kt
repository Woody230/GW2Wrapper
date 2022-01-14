package com.bselzer.gw2.v2.chatlink.build.profession

import com.bselzer.ktx.function.collection.fill
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
) : LinkProfessionData() {
    companion object {
        const val CODE: Byte = 4
    }

    override fun getData(): ByteArray {
        val pets = byteArrayOf(activePet.terrestrialId, inactivePet.terrestrialId, activePet.aquaticId, inactivePet.aquaticId)
        val filler = listOf<Byte>().fill(12) { 0 }
        return pets + filler
    }

    override fun decode(bytes: ArrayDeque<Byte>) {
        // Ensure bytes size.
        super.decode(bytes)

        activePet.terrestrialId = bytes.removeFirst()
        inactivePet.terrestrialId = bytes.removeFirst()
        activePet.aquaticId = bytes.removeFirst()
        inactivePet.aquaticId = bytes.removeFirst()
    }
}