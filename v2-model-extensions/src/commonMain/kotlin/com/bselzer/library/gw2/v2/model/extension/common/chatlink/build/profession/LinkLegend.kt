package com.bselzer.library.gw2.v2.model.extension.common.chatlink.build.profession

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
)