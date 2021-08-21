package com.bselzer.library.gw2.v2.chatlink.common

/**
 * A link to a skin.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skins">the wiki</a>
 */
class SkinLink(id: Int = 0) : IdLink(id)
{
    override val header: Byte = 10
}