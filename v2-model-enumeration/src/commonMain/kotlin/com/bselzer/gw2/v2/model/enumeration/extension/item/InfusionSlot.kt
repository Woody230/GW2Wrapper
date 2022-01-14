package com.bselzer.gw2.v2.model.enumeration.extension.item

import com.bselzer.gw2.v2.model.enumeration.item.InfusionUpgradeFlag
import com.bselzer.gw2.v2.model.item.detail.infusion.InfusionSlot
import com.bselzer.ktx.serialization.function.validEnumValues

/**
 * The [InfusionSlot.flags] as a collection of [InfusionUpgradeFlag]
 */
fun InfusionSlot.flags(): List<InfusionUpgradeFlag> = flags.validEnumValues()