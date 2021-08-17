package com.bselzer.library.gw2.v2.model.common.achievement.bit

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Skin")
data class SkinBit(
    /**
     * The id of the skin.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skins">the wiki</a>
     */
    override val id: Int = 0
) : AchievementBit(), Identifiable<Int>