package com.bselzer.gw2.v2.chatlink.build.profession

import com.bselzer.gw2.v2.chatlink.build.LinkComponent
import com.bselzer.gw2.v2.model.legend.LegendCode
import kotlinx.serialization.Serializable

@Serializable
data class LinkLegend(
    /**
     * The id of the land legend code.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legends">the wiki</a>
     */
    var terrestrialId: LegendCode = LegendCode(),

    /**
     * The id of the water legend code.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/legends">the wiki</a>
     */
    var aquaticId: LegendCode = LegendCode()
) : LinkComponent() {
    override val size: Int = 2

    override fun getData(): ByteArray = byteArrayOf(terrestrialId.value, aquaticId.value)

    override fun decode(bytes: ArrayDeque<Byte>) {
        // Ensure bytes size.
        super.decode(bytes)

        terrestrialId = LegendCode(bytes.removeFirst())
        aquaticId = LegendCode(bytes.removeFirst())
    }
}