package com.bselzer.library.gw2.v2.model.enumeration.extension.pvp

import com.bselzer.library.gw2.v2.model.enumeration.profession.AttributeName
import com.bselzer.library.gw2.v2.model.pvp.PvpAmulet
import com.bselzer.library.kotlin.extension.serialization.function.validEnumValues

/**
 * The [PvpAmulet.attributes] with [AttributeName] keys
 */
fun PvpAmulet.attributes(): Map<AttributeName, Int> = attributes.validEnumValues()