package com.bselzer.library.gw2.v2.chatlink.common

/**
 * A link to dialogue.
 * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format/0x03_codes">the wiki</a>
 */
class NpcTextLink(id: Int = 0) : IdLink(id)
{
    override val header: Byte = 3
}