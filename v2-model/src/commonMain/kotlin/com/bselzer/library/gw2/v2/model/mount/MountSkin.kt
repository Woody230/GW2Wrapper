package com.bselzer.library.gw2.v2.model.mount

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MountSkin(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("name")
    val name: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    /**
     * The id of the mount type.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mounts/types">the wiki</a>
     */
    @SerialName("mount")
    val mountType: String = "",

    /**
     * The dye slots.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    @SerialName("dye_slots")
    val dyeSlots: List<DyeSlot> = emptyList()
) : Identifiable<Int>