package com.bselzer.library.gw2.v2.model.extension.common.model.item

import com.bselzer.library.gw2.v2.model.common.item.detail.infusion.InfusionSlot
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.InfusionUpgradeFlag
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

/**
 * The [InfusionSlot.flags] as a collection of [InfusionUpgradeFlag]
 */
fun InfusionSlot.flags(): List<InfusionUpgradeFlag> = flags.validEnumValues()