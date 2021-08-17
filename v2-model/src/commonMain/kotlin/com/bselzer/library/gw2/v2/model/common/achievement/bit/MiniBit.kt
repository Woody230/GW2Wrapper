package com.bselzer.library.gw2.v2.model.common.achievement.bit

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Minipet")
data class MiniBit(
    /**
     * The id of the mini.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/minis">the wiki</a>
     */
    @SerialName("id")
    override val id: Int = 0
) : AchievementBit(), Identifiable<Int>