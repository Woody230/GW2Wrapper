package com.bselzer.gw2.v2.chatlink

import com.bselzer.gw2.v2.model.skin.SkinId

/**
 * A link to a skin.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skins">the wiki</a>
 */
class SkinLink(id: SkinId = SkinId()) : IdLink(id.value) {
    override val header: Byte = 10
}