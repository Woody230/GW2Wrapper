package com.bselzer.library.gw2.v2.model.extension.common.model

import com.bselzer.library.gw2.v2.model.common.profession.skill.ElementalistSkill
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.AttunementName
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [ElementalistSkill.attunementRequired] as an [AttunementName]
 */
fun ElementalistSkill.attunementRequired(): AttunementName? = attunementRequired.enumValueOrNull<AttunementName>()