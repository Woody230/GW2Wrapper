package com.bselzer.library.gw2.v2.chatlink.common.build.profession

import com.bselzer.library.gw2.v2.chatlink.common.build.LinkComponent
import kotlinx.serialization.Serializable

@Serializable
data class LinkPet(
    /**
     * The id of the land pet.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pets">the wiki</a>
     */
    var terrestrialId: Byte = 0,

    /**
     * The id of the water pet.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pets">the wiki</a>
     */
    var aquaticId: Byte = 0
) : LinkComponent()
{
    override val size: Int = 2

    override fun getData(): ByteArray = byteArrayOf(terrestrialId, aquaticId)

    override fun decode(bytes: ArrayDeque<Byte>)
    {
        // Ensure byte size.
        super.decode(bytes)

        terrestrialId = bytes.removeFirst()
        aquaticId = bytes.removeFirst()
    }
}