package com.bselzer.library.gw2.v2.model.extension.common.model.mount

import com.bselzer.library.gw2.v2.model.common.mount.MountSkill
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.skill.SkillSlot
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [MountSkill.slot] as a [SkillSlot]
 */
fun MountSkill.slot(): SkillSlot? = slot.enumValueOrNull<SkillSlot>()