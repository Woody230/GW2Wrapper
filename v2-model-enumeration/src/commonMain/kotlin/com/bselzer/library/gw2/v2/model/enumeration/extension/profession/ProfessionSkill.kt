package com.bselzer.library.gw2.v2.model.enumeration.extension.profession

import com.bselzer.library.gw2.v2.model.enumeration.profession.AttunementName
import com.bselzer.library.gw2.v2.model.enumeration.profession.ProfessionName
import com.bselzer.library.gw2.v2.model.enumeration.skill.SkillSlot
import com.bselzer.library.gw2.v2.model.profession.ProfessionSkill
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

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