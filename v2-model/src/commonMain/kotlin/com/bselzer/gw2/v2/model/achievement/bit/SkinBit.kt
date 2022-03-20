package com.bselzer.gw2.v2.model.achievement.bit

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.skin.SkinId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Skin")
data class SkinBit(
    /**
     * The id of the skin.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skins">the wiki</a>
     */
    override val id: SkinId = SkinId()
) : AchievementBit(), Identifiable<Int>