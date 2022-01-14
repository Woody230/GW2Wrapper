package com.bselzer.gw2.v2.model.enumeration.extension.mount

import com.bselzer.gw2.v2.model.enumeration.skill.SkillSlot
import com.bselzer.gw2.v2.model.mount.MountSkill
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [MountSkill.slot] as a [SkillSlot]
 */
fun MountSkill.slot(): SkillSlot? = slot.enumValueOrNull<SkillSlot>()