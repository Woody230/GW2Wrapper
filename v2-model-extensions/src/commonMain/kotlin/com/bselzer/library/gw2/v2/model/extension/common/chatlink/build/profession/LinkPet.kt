package com.bselzer.library.gw2.v2.model.extension.common.chatlink.build.profession

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
)