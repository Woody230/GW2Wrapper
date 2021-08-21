package com.bselzer.library.gw2.v2.model.enumeration.common.extension.profession

import com.bselzer.library.gw2.v2.model.common.profession.ProfessionWeaponSkill
import com.bselzer.library.gw2.v2.model.enumeration.common.profession.WeaponType
import com.bselzer.library.gw2.v2.model.enumeration.common.skill.SkillSlot
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [ProfessionWeaponSkill.slot] as a [SkillSlot]
 */
fun ProfessionWeaponSkill.slot(): SkillSlot? = slot.enumValueOrNull<SkillSlot>()

/**
 * The [ProfessionWeaponSkill.offhand] as a [WeaponType]
 */
fun ProfessionWeaponSkill.offhand(): WeaponType? = offhand.enumValueOrNull<WeaponType>()
