package com.bselzer.library.gw2.v2.model.common.mount

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MountType(
    @SerialName("id")
    override val id: String = "",

    @SerialName("name")
    val name: String = "",

    /**
     * The id of the default skin.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mounts/skins">the wiki</a>
     */
    @SerialName("default_skin")
    val defaultSkinId: Int = 0,

    /**
     * The ids of all skins.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mounts/skins">the wiki</a>
     */
    @SerialName("skins")
    val skinIds: List<Int> = emptyList(),

    @SerialName("skills")
    val skills: List<MountSkill> = emptyList()
) : Identifiable<String>