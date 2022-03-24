package com.bselzer.gw2.v2.chatlink

import com.bselzer.gw2.v2.model.outfit.OutfitId

/**
 * The link to an outfit.
 * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format/0x0B_codes">the wiki</a>
 */
class OutfitLink(id: OutfitId = OutfitId()) : IdLink(id.value) {
    override val header: Byte = 11
}