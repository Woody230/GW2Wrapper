package com.bselzer.library.gw2.v2.model.extension.common.model

import com.bselzer.library.gw2.v2.model.common.profession.skill.ProfessionSkill
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.skill.SkillSlot
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [ProfessionSkill.slot] as a [SkillSlot]
 */
fun ProfessionSkill.slot(): SkillSlot? = slot.enumValueOrNull<SkillSlot>()