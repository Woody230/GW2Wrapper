package com.bselzer.gw2.v2.model.achievement.bit

import com.bselzer.gw2.v2.model.mini.MiniId
import com.bselzer.ktx.value.identifier.Identifiable
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
    override val id: MiniId = MiniId()
) : AchievementBit(), Identifiable<MiniId, Int>