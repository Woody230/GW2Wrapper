package com.bselzer.gw2.v2.chatlink.build.profession

import com.bselzer.gw2.v2.chatlink.build.LinkComponent
import com.bselzer.gw2.v2.model.pet.PetId
import kotlinx.serialization.Serializable

@Serializable
data class LinkPet(
    /**
     * The id of the land pet.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pets">the wiki</a>
     */
    var terrestrialId: PetId = PetId(),

    /**
     * The id of the water pet.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pets">the wiki</a>
     */
    var aquaticId: PetId = PetId()
) : LinkComponent() {
    override val size: Int = 2

    override fun getData(): ByteArray = byteArrayOf(terrestrialId.value, aquaticId.value)

    override fun decode(bytes: ArrayDeque<Byte>) {
        // Ensure byte size.
        super.decode(bytes)

        terrestrialId = PetId(bytes.removeFirst())
        aquaticId = PetId(bytes.removeFirst())
    }
}