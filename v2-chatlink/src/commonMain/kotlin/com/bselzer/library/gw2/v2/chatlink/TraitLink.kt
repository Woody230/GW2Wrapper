package com.bselzer.library.gw2.v2.chatlink

/**
 * A link to a trait
 * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format/0x07_codes">the wiki</a>
 */
class TraitLink(id: Int = 0) : IdLink(id)
{
    override val header: Byte = 7
}