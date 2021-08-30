package com.bselzer.library.gw2.v2.model.guild.emblem

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildEmblemComponent(
    /**
     * The id of the emblem component.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem/backgrounds">emblem backgrounds on the wiki</a>
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem/foregrounds">emblem foregrounds on the wiki</a>
     */
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The ids of the colors used.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    @SerialName("colors")
    val colors: List<Int> = emptyList()
) : Identifiable<Int>