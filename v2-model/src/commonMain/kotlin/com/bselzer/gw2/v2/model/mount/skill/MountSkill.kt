package com.bselzer.gw2.v2.model.mount.skill

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.skill.SkillId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MountSkill(
    // TODO these seem to be v2/skills ids because they are high though they aren't available
    @SerialName("id")
    override val id: SkillId = SkillId(),

    @SerialName("slot")
    val slot: com.bselzer.gw2.v2.model.wrapper.SkillSlot = com.bselzer.gw2.v2.model.wrapper.SkillSlot()
) : Identifiable<Int>