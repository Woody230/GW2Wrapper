package com.bselzer.gw2.v2.model.guild.emblem

import com.bselzer.gw2.v2.model.color.DyeColorId
import com.bselzer.ktx.value.identifier.Identifiable
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
    override val id: GuildEmblemComponentId = GuildEmblemComponentId(),

    /**
     * The ids of the colors used.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    @SerialName("colors")
    val colors: List<DyeColorId> = emptyList()
) : Identifiable<Int>