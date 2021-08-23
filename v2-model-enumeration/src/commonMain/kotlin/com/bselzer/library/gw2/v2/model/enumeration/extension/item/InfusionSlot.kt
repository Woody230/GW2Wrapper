package com.bselzer.library.gw2.v2.model.enumeration.extension.item

import com.bselzer.library.gw2.v2.model.enumeration.item.InfusionUpgradeFlag
import com.bselzer.library.gw2.v2.model.item.detail.infusion.InfusionSlot
import com.bselzer.library.kotlin.extension.serialization.function.validEnumValues

/**
 * The [InfusionSlot.flags] as a collection of [InfusionUpgradeFlag]
 */
fun InfusionSlot.flags(): List<InfusionUpgradeFlag> = flags.validEnumValues()