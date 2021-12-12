package com.bselzer.gw2.v2.chatlink

/**
 * A link to a point of interest (landmarks, waypoints, vistas).
 * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format/0x04_codes">the wiki</a>
 */
class MapLink(id: Int = 0) : IdLink(id) {
    override val header: Byte = 4
}