package com.bselzer.library.gw2.v2.model.extension.common.chatlink

/**
 * The link to an outfit.
 * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format/0x0B_codes">the wiki</a>
 */
class OutfitLink(id: Int = 0) : IdLink(id)
{
    override val header: Byte = 11
}