package com.bselzer.library.gw2.v2.model.extension.common.model.skill

import com.bselzer.library.gw2.v2.model.common.profession.skill.ThiefSkill
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.ProfessionName
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.WeaponType
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [ThiefSkill.offhandRequired] as a [WeaponType]
 */
fun ThiefSkill.offhandRequired(): WeaponType? = offhandRequired.enumValueOrNull<WeaponType>()

/**
 * The [ThiefSkill.stealSource] as a [ProfessionName]
 */
fun ThiefSkill.stealSource(): ProfessionName? = stealSource.enumValueOrNull<ProfessionName>()