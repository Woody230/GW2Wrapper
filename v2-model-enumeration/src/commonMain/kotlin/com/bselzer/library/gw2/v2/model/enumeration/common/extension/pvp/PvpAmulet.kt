package com.bselzer.library.gw2.v2.model.enumeration.common.extension.pvp

import com.bselzer.library.gw2.v2.model.common.pvp.PvpAmulet
import com.bselzer.library.gw2.v2.model.enumeration.common.profession.AttributeName
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

/**
 * The [PvpAmulet.attributes] with [AttributeName] keys
 */
fun PvpAmulet.attributes(): Map<AttributeName, Int> = attributes.validEnumValues()