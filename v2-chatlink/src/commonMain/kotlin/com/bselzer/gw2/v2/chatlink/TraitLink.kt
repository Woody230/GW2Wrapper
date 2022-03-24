package com.bselzer.gw2.v2.chatlink

import com.bselzer.gw2.v2.model.trait.TraitId

/**
 * A link to a trait
 * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format/0x07_codes">the wiki</a>
 */
class TraitLink(id: TraitId = TraitId()) : IdLink(id.value) {
    override val header: Byte = 7
}