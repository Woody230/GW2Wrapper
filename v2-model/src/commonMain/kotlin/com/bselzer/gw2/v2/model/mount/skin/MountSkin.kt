package com.bselzer.gw2.v2.model.mount.skin

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.mount.type.MountTypeId
import com.bselzer.gw2.v2.model.value.MountName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MountSkin(
    @SerialName("id")
    override val id: MountSkinId = MountSkinId(),

    @SerialName("name")
    val name: MountName = MountName(),

    @SerialName("icon")
    val iconLink: String = "",

    /**
     * The id of the mount type.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mounts/types">the wiki</a>
     */
    @SerialName("mount")
    val mountType: MountTypeId = MountTypeId(),

    /**
     * The dye slots.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/colors">the wiki</a>
     */
    @SerialName("dye_slots")
    val dyeSlots: List<MountDyeSlot> = emptyList()
) : Identifiable<Int>