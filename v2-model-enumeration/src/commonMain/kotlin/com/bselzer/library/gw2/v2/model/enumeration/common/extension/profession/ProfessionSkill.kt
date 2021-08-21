package com.bselzer.library.gw2.v2.model.enumeration.common.extension.profession

import com.bselzer.library.gw2.v2.model.common.profession.ProfessionSkill
import com.bselzer.library.gw2.v2.model.enumeration.common.profession.AttunementName
import com.bselzer.library.gw2.v2.model.enumeration.common.profession.ProfessionName
import com.bselzer.library.gw2.v2.model.enumeration.common.skill.SkillSlot
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [ProfessionSkill.slot] as a [SkillSlot]
 */
fun ProfessionSkill.slot(): SkillSlot? = slot.enumValueOrNull<SkillSlot>()

/**
 * The [ProfessionSkill.attunement] as an [AttunementName]
 */
fun ProfessionSkill.attunement(): AttunementName? = attunement.enumValueOrNull<AttunementName>()

/**
 * The [ProfessionSkill.source] as a [ProfessionName]
 */
fun ProfessionSkill.source(): ProfessionName? = source.enumValueOrNull<ProfessionName>()