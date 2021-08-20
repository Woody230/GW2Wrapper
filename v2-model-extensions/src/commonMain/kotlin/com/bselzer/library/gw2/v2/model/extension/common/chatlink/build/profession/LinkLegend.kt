package com.bselzer.library.gw2.v2.model.extension.common.chatlink.build.profession

import com.bselzer.library.gw2.v2.model.extension.common.chatlink.build.LinkComponent
import kotlinx.serialization.Serializable

@Serializable
data class LinkLegend(
    /**
     * The id of the land legend code.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legends">the wiki</a>
     */
    var terrestrialId: Byte = 0,

    /**
     * The id of the water legend code.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legends">the wiki</a>
     */
    var aquaticId: Byte = 0
) : LinkComponent()
{
    override val size: Int = 2

    override fun getData(): ByteArray = byteArrayOf(terrestrialId, aquaticId)

    override fun decode(bytes: ArrayDeque<Byte>)
    {
        // Ensure bytes size.
        super.decode(bytes)

        terrestrialId = bytes.removeFirst()
        aquaticId = bytes.removeFirst()
    }
}