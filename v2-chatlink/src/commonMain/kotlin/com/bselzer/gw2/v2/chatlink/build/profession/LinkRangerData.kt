package com.bselzer.gw2.v2.chatlink.build.profession

import com.bselzer.gw2.v2.model.pet.PetId
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
    override fun getData(): ByteArray {
        val pets = byteArrayOf(activePet.terrestrialId.value, inactivePet.terrestrialId.value, activePet.aquaticId.value, inactivePet.aquaticId.value)
        val filler = listOf<Byte>().fill(12) { 0 }
        return pets + filler
    }

    override fun decode(bytes: ArrayDeque<Byte>) {
        // Ensure bytes size.
        super.decode(bytes)

        activePet.terrestrialId = PetId(bytes.removeFirst())
        inactivePet.terrestrialId = PetId(bytes.removeFirst())
        activePet.aquaticId = PetId(bytes.removeFirst())
        inactivePet.aquaticId = PetId(bytes.removeFirst())
    }
}