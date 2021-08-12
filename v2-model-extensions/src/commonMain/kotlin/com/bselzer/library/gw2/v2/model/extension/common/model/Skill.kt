package com.bselzer.library.gw2.v2.model.extension.common.model

import com.bselzer.library.gw2.v2.model.common.skill.Skill
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.AttunementName
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.ProfessionName
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.WeaponType
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.skill.SkillCategory
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.skill.SkillFlag
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.skill.SkillSlot
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.skill.SkillType
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull
import com.bselzer.library.kotlin.extension.function.common.objects.validEnumValues

/**
 * The [Skill.type] as a [SkillType]
 */
fun Skill.type(): SkillType? = type.enumValueOrNull<SkillType>()

/**
 * The [Skill.weaponType] as a [WeaponType]
 */
fun Skill.weaponType(): WeaponType? = type.enumValueOrNull<WeaponType>()

/**
 * The [Skill.professions] as a collection of [ProfessionName]
 */
fun Skill.professions(): List<ProfessionName> = professions.validEnumValues()

/**
 * The [Skill.slot] as a [SkillSlot]
 */
fun Skill.slot(): SkillSlot? = slot.enumValueOrNull<SkillSlot>()

/**
 * The [Skill.categories] as a collection of [SkillCategory]
 */
fun Skill.categories(): List<SkillCategory> = categories.validEnumValues()

/**
 * The [Skill.attunement] as an [AttunementName]
 */
fun Skill.attunement(): AttunementName? = attunement.enumValueOrNull<AttunementName>()

/**
 * The [Skill.dualAttunement] as an [AttunementName]
 */
fun Skill.dualAttunement(): AttunementName? = dualAttunement.enumValueOrNull<AttunementName>()

/**
 * The [Skill.dualWield] as a [WeaponType]
 */
fun Skill.dualWield(): WeaponType? = dualWield.enumValueOrNull<WeaponType>()

/**
 * The [Skill.flags] as a collection of [SkillFlag]
 */
fun Skill.flags(): List<SkillFlag> = flags.validEnumValues()