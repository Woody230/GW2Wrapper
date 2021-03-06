package com.bselzer.gw2.v2.model.mount.type

import com.bselzer.gw2.v2.model.enumeration.wrapper.MountName
import com.bselzer.gw2.v2.model.mount.skill.MountSkill
import com.bselzer.gw2.v2.model.mount.skin.MountSkinId
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MountType(
    @SerialName("id")
    override val id: MountTypeId = MountTypeId(),

    @SerialName("name")
    val name: MountName = MountName(),

    /**
     * The id of the default skin.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mounts/skins">the wiki</a>
     */
    @SerialName("default_skin")
    val defaultSkinId: MountSkinId = MountSkinId(),

    /**
     * The ids of all skins.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mounts/skins">the wiki</a>
     */
    @SerialName("skins")
    val skinIds: List<MountSkinId> = emptyList(),

    @SerialName("skills")
    val skills: List<MountSkill> = emptyList()
) : Identifiable<MountTypeId, String>