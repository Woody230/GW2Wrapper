package com.bselzer.gw2.v2.model.enumeration.extension.pvp

import com.bselzer.gw2.v2.model.enumeration.profession.AttributeName
import com.bselzer.gw2.v2.model.pvp.amulet.PvpAmulet
import com.bselzer.ktx.serialization.function.validEnumValues

/**
 * The [PvpAmulet.attributes] with [AttributeName] keys
 */
fun PvpAmulet.attributes(): Map<AttributeName, Int> = attributes.validEnumValues()