package com.bselzer.library.gw2.v2.model.enumeration.common.extension.mount

import com.bselzer.library.gw2.v2.model.common.mount.MountSkill
import com.bselzer.library.gw2.v2.model.enumeration.common.skill.SkillSlot
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [MountSkill.slot] as a [SkillSlot]
 */
fun MountSkill.slot(): SkillSlot? = slot.enumValueOrNull<SkillSlot>()